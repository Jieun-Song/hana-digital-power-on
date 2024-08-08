package org.example.service;

import org.example.WordSet;
import org.example.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;

public class WordRegisterService {
    private WordDao wordDao;
    @Autowired
    public WordRegisterService(WordDao wordDao){
        this.wordDao = wordDao;
    }
    public void register(WordSet wordSet){
        String wordKey = wordSet.getWordKey();
        if(verify(wordKey)){
            wordDao.insert(wordSet);
        }else {
            System.out.println("the word has already registerd");
        }
    }
    public boolean verify(String wordKey){
        WordSet wordSet = wordDao.select(wordKey);
        return wordSet == null?true:false;
    }
    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

}
