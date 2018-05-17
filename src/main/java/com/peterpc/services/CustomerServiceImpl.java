package com.peterpc.services;

import com.peterpc.model.Customers;
import com.peterpc.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomersRepository customerrepository;

    Customers Klaptraet = new Customers();
    Customers SticksNSushi = new Customers();
    Customers BurgerKing = new Customers();

    public void addCustomers() {
        Klaptraet.setKundeNr(6043920);
        Klaptraet.setCustomerName("Cafe Klaptræet");
        Klaptraet.setCustomerAddress("Kultorvet 11, 1175 Kbh K");

        customerrepository.save(Klaptraet);

        //SticksNSushi.setKundeNr(6000822);
       // SticksNSushi.setCustomerAddress("Arni Magnussons Gade 2, 1577 Kbh V");
        //SticksNSushi.setCustomerName("Sticks N Sushi Tivoli Hotel");

        customerrepository.save(SticksNSushi);

       // BurgerKing.setCustomerName("Burger King");
       // BurgerKing.setKundeNr(603525);
        //BurgerKing.setCustomerAddress("Horsensvej 121, 7100 Vejle");

        customerrepository.save(BurgerKing);

        System.out.println("Added following customers : " + customerrepository.findAll());

    }


}