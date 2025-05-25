package com.devhenrique.dslist.servicies;

import com.devhenrique.dslist.dto.GameListDto;
import com.devhenrique.dslist.dto.GameMinDto;
import com.devhenrique.dslist.projections.GameMinProjection;
import com.devhenrique.dslist.repositories.GameListRepo;
import com.devhenrique.dslist.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepo gameListRepo;

    @Autowired
    private GameRepo gameRepo;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        return gameListRepo.findAll().stream().map(GameListDto::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
       List<GameMinProjection> list = gameRepo.searchByList(listId);

       GameMinProjection obj = list.remove(sourceIndex);
       list.add(destinationIndex, obj);

       int min = sourceIndex < destinationIndex? sourceIndex:destinationIndex;
       int max = sourceIndex < destinationIndex? destinationIndex:sourceIndex;

       for (int i = min; i < max; i++){
           gameListRepo.updateBelongingPosition(listId, list.get(i).getId(), i );
       }
    }
}
