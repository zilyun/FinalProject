package com.mbti.finalproject.mybatis.mapper.Table;

import com.mbti.finalproject.domain.Board.BoardUpfiles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpfilesMapper {
    void insertFile(BoardUpfiles file);

    List<BoardUpfiles> getFilesbyBoardNum(int boardNum);

    int deleteFile(int boardNum);

    void insertAnnounceFile(BoardUpfiles file);

    List<BoardUpfiles> getFilesbyAnnBoardNum(int num);

    void insertProjectFile(BoardUpfiles file);
}
