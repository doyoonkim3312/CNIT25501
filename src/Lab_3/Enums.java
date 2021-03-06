package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

enum UserType {CLIENT, MANAGER, GUEST, NULL};

/**
 * Value for sender validation.
 * LOG ON USER ALWAYS ASSIGNED TO USER 1
 * This enum class should be modified later in order to corresponding chatroom that has more than 2 users.
 */
enum SenderRotation {USER1, USER2, NULL}
