package org.example.service;

import org.example.WordSet;
import org.example.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class WordSearchService {

    private WordDao wordDao;
    @Autowired
    public WordSearchService(WordDao wordDao){
        this.wordDao = wordDao;
    }

    public WordSet searchWord(String wordKey){
        if(verify(wordKey)){
            return wordDao.select(wordKey);
        }else{
            System.out.println("WordKey information is available");
        }
        return null;
    }

    public boolean verify(String wordKey){
        WordSet wordSet = wordDao.select(wordKey);
        return wordSet!= null? true:false;
    }

    public void setWordDao(WordDao wordDao){
        this.wordDao= wordDao;
    }
}
