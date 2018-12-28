package org.flp.capbook.service;
import java.util.List;

import org.flp.capbook.model.FriendsList;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;




public interface IGroupsService {

	List<FriendsList> findFriends();

	List<Groups> createGroup(Groups groups);

	List<Group_Topic> post(Group_Topic topic);

	List<FriendsList> exitFriends(Integer id);

}
