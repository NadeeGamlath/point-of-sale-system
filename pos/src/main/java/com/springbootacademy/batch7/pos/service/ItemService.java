package com.springbootacademy.batch7.pos.service;


import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemUpdateDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusMapStruct(String itemName);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    ItemDTO getItemById(int itemid);

    List<ItemGetResponseDTO> getItemByName(String itemName);
}
