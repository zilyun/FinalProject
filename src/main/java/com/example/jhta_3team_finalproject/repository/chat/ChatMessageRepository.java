package com.example.jhta_3team_finalproject.repository.chat;

import com.example.jhta_3team_finalproject.domain.chat.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query(value = """
        select * from chat_message where chat_room_num = :chatRoomNum
                                     and message_content like concat('%', :messageContent, '%')
        """, nativeQuery = true)
    List<ChatMessage> searchChatMessages(@Param("chatRoomNum") Long chatRoomNum, @Param("messageContent") String messageContent);

}
