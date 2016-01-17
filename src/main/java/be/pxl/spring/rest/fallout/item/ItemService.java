package be.pxl.spring.rest.fallout.item;

import be.pxl.spring.rest.fallout.security.user.User;
import be.pxl.spring.rest.fallout.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public Item pickUp(UUID itemID, String userName) {
        Item existingItem = itemRepository.findOne(itemID);
        User loggedInUser = userRepository.findByName(userName);
        loggedInUser.addItemToInventory(existingItem);
        userRepository.save(loggedInUser);

        System.out.println(String.format("%s picked up [%s]", loggedInUser.getName(), existingItem.getName()));

        return itemRepository.save(existingItem);
    }
}
