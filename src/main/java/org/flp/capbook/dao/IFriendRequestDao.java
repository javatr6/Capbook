package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Friend_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("FriendrequestDao")
@Transactional
public interface IFriendRequestDao extends JpaRepository<Friend_request, Integer> {
	@Query(" select u.userName as userName from UserProfile u where u.userId in (select r.senderId from Friend_request r where r.receiverId = :id and r.status ='pending')")
	public List<Friend_request> getUsers(@Param("id") Integer id);

	@Query("from Friend_request r where senderId = :senderId and receiverId = :receiverId ")
	public Friend_request getFriend(@Param("senderId")Integer userId,@Param("receiverId") Integer userSession);
	
	@Query(value="select f.sender_id from friend_request f where f.receiver_id=:id and f.status ='accept'",nativeQuery=true)
	public List<Integer> getAllFriendrequest1(@Param("id")Integer userId);
	
	
//	@Query("select u.email from UserProfile u where u.userId in (select f.receiverId from Friend_request f where f.senderId=:id  and f.status ='accept')")
	@Query("select f.receiverId from Friend_request f where f.senderId=:id and f.status ='accept'")
	public List<Integer> getAllFriendrequest2(@Param("id")Integer userId);
	

}
