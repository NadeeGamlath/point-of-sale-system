package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemUpdateDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Customer;
import com.springbootacademy.batch7.pos.entity.Item;
import com.springbootacademy.batch7.pos.repo.ItemRepo;
import com.springbootacademy.batch7.pos.service.ItemService;
import com.springbootacademy.batch7.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if(!itemRepo.existsById((item.getItemId()))){
            itemRepo.save(item);
            return item.getItemId() + " saved successfully ";
        }else{
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> item = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName , b);
        if(item.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(item, new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item is not Active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusMapStruct(String itemName) {
        boolean b = true;
        List<Item> item = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName , b);
        if(item.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(item);
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item is not Active");
        }
    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if(itemRepo.existsById(itemUpdateDTO.getId())){
          Item item = itemRepo.getReferenceById(itemUpdateDTO.getId());
          modelMapper.map(itemUpdateDTO,item);
          itemRepo.save(item);
            return "updated";
        }else{
          throw  new RuntimeException("no data");
      }

    }

    @Override
    public ItemDTO getItemById(int itemid) {
        if(itemRepo.existsById(itemid)){
            Item item = itemRepo.getReferenceById(itemid);
            ItemDTO itemDTO = modelMapper.map(item,ItemDTO.class);
            return  itemDTO;
        }else {
            throw new RuntimeException("No customer");
        }

    }
    @Override
    public List<ItemGetResponseDTO> getItemByName(String itemName) {
        List<Item> item = itemRepo.findAllByItemNameEquals(itemName);
        if(item.size()>0){
            List<ItemGetResponseDTO> itemDTOS = itemMapper.entityListToDtoList(item);
            return itemDTOS;
        }else{
            throw new RuntimeException("Item is not Available");
        }
    }

}

