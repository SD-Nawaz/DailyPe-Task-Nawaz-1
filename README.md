Task
Make a spring boot application exposing 4 endpoints such as below, and screen record sample API calls to these 4 endpoints after finishing the task.

1. /create_user

  A. The function should be a POST method accepting a JSON body containing the following keys:
  
    i. full_name (String): The user's full name.
    
    ii. mob_num (String): The user's mobile number.
    
    iii. pan_num (String): The user's PAN number (Permanent Account Number).
    
    iv. manager_id (uuid): The user’s manager_id (may not always be in the payload while creating the user, can be updated later as well)
  
  B. The function should validate the following:
  
    i. full_name: Must not be empty.
    
    ii. mob_num: Must be a valid 10-digit mobile number, and if the user passes the number with a country code or a prefix adjust the number accordingly before entering it into the db. valid prefixes can be (0, +91)
    
    iii. pan_num: Must be a valid PAN number (e.g., AABCP1234C). If the pan is not entered in all caps, convert it to all caps before entering it to the db.
    
    iv. manager_id: The manager_id should be validated as an active manager from a manager table, which you need to create and prefill for testing. Mention in the readme the test data for managers, also the schema that you used to create the manager table with all the fields you chose to be necessary.
  
  C. If any of the validations fail, the function should return an appropriate error message.
  
  D. If all validations are successful, the function should store the user's data in a database against a user_id that is filled with a UUID v4 value.
  
  E. The function should return a success message upon successful user creation.
  
  F. Each entry should have a created_at timestamp and updated_at timestamp which is empty initially and a key is_active which is true by default when an entry is created.

2. /get_users

  A. The function should be a POST method and accessible at the /get_users endpoint.
  
  B. The function should retrieve all user records from the database.
  
  C. If there are no users registered, the function should return an empty JSON array.
  
  D. When a mob_num or a user_id is passed it should only return that particular user’s information
  
  E. When a manager_id is passed it should return all users with that manager.
  
  F. The function should return a JSON object with a key users containing an array of user objects. Each user object should have the following structure:

        {
          "user_id": <user_id>,
          "manager_id": <manager_id>,
          "full_name": <full_name>,
          "mob_num": <mob_num>,
          "pan_num": <pan_num>,
          "created_at": <created_at_timestamp>,
          "updated_at": <updated_at_timestamp>,
          "is_active":
        }

3. /delete_user

  A. The function should be a POST method accepting a JSON body containing either of the following keys:
  
    i. user_id (String): The unique identifier of the user to be deleted.
  
    ii. mob_num (String): The unique identifier of the user to be deleted.
  
  B. The function should check if the provided user_id or a user against the mob_num exists in the database.
  
  C. If the user_id is found, the corresponding user record should be deleted from the database.
  
  D. If the user_id is not found, the function should return an appropriate error message.
  
  E. The function should return a success message upon successful deletion.

4. /update_user

  A. The function should be a POST method accepting a JSON body containing the following keys:
  
  B. Bulk update, i.e. when a user_list is passed with update_data, should only work when only the manager_id is being updated, in rest of the situations it should return an error message with the extra keys that these keys can be updated on a individual basis only and not in bulk.
  
    i . user_ids (List): A list of unique identifiers of the users to be updated.
  
    ii. update_data (Object): An object containing the data to be updated. It can have one or more of the following optional keys:
  
        full_name (String): The updated full name.
  
        mob_num (String): The updated mobile number.
  
        pan_num (String): The updated PAN number.
  
        manager_id (String): The updated manager ID.
  
  C. The function should check if the provided user_ids exist in the database.
  
  D. If any of the user_ids are not found, the function should skip updating those users and return an appropriate error message.
  
  E. If all user_ids are found, update the users' data with the provided update_data.
  
  F. The function should validate the updated data based on the same criteria as the /create_user endpoint.
  
  G. If any validation fails for the updated data, the function should return an appropriate error message.
  
  H. If the manager_id is being updated, for the first time just insert the manager_id against the user and then add the updated_at, but if the user already has a manager then the current database entry should be made is_active = false, and a new entry for the user should be created with its old data but the new manager_id and updated timestamps.
  
  I. There should be validation before the manager_id is changed to ensure that the manager actually exists in the managers' table.
  
  J. The function should return a success message upon successful user update.
  
  K. Each updated entry should have an updated_at timestamp.

Additional Instructions

  i. Create an empty Git repository and share it with us so we can monitor progress.
  
  ii. Ensure error handling and logging are implemented properly.
  
  iii. Make timely and meaningful commits.
  
  iv. Ensure proper return statements for each type of error.
  
  v. Reuse the code wherever possible and make sure each api has a missing keys check.
