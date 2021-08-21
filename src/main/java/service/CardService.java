package service;

import dao.CardRepository;
import model.Card;

import java.util.List;

public class CardService {
    private final CardRepository cardRepository = new CardRepository();

    public CardService(){};

    public Card findCard(int id){
        return cardRepository.findById(id);
    }

    public List<Card> findAllCards(){
        return cardRepository.findAll();
    }

    public void saveCard(Card card){
        cardRepository.create(card);
    }

    public void updateCard(Card card){
        cardRepository.update(card);
    }

    public void deleteCard(Card card){
        cardRepository.delete(card);
    }
}
