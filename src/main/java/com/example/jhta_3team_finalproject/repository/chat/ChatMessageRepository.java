//package com.example.jhta_3team_finalproject.repository.chat;
//
//import com.example.jhta_3team_finalproject.domain.chat.ChatMessage;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
//
//    @Query(value = """
//        WITH MessageData AS (
//            SELECT
//                DATE(cm.send_time) AS time_stamp,
//                cm.message_num,
//                cm.sender_id,
//                cm.chat_room_num,
//                cm.message_content,
//                cm.file_url,
//                cm.file_origin_name,
//                cm.read_count,
//                cm.send_time AS message_send_time,
//                u.user_id,
//                u.user_name,
//                u.user_profile_picture
//            FROM chat_message cm
//            JOIN user u ON cm.sender_id = u.user_id
//            WHERE cm.chat_room_num = :#{#chatMessage.chatRoomNum}
//            AND MATCH(cm.message_content) AGAINST(:#{#chatMessage.messageContent} IN BOOLEAN MODE)
//        )
//        SELECT
//            time_stamp,
//            NULL AS message_num,
//            NULL AS sender_id,
//            chat_room_num,
//            NULL AS message_content,
//            NULL AS file_url,
//            NULL AS file_origin_name,
//            NULL AS read_count,
//            MIN(message_send_time) AS send_time,
//            NULL AS user_id,
//            NULL AS user_name,
//            NULL AS user_profile_picture
//        FROM MessageData
//        GROUP BY time_stamp
//        UNION ALL
//        SELECT
//            time_stamp,
//            message_num,
//            sender_id,
//            chat_room_num,
//            message_content,
//            file_url,
//            file_origin_name,
//            read_count,
//            message_send_time AS send_time,
//            user_id,
//            user_name,
//            user_profile_picture
//        FROM MessageData
//        ORDER BY time_stamp, send_time ASC
//        """, nativeQuery = true)
//    List<ChatMessage> searchChatMessages(@Param("chatMessage") ChatMessage chatMessage);
//}
