package org.example;

import org.example.config.SessionCreator;
import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public Main() {
        sessionFactory = SessionCreator.getInstance().getSessionFactory();
        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Customer customer = main.createCustomer();
        main.returnRental();
        main.customerRentInventory(customer);
        //main.addNewFilm();
    }

    private void addNewFilm() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Language language = languageDAO.getById((byte) 1);
            Film film = new Film();
            film.setActors(Set.of(actorDAO.getById((short) 1)));
            film.setSpecialFeatures(Set.of(Feature.BEHIND_THE_SCENES));
            film.setLanguage(language);
            film.setLength((short) 123);
            film.setDescription("aaaa");
            film.setOriginalLanguage(language);
            film.setRating(Rating.R);
            film.setReplacementCost(BigDecimal.TEN);
            film.setRentalRate(BigDecimal.ONE);
            film.setTitle("One actor film");
            film.setRentalDuration((byte) 10);
            film.setReleaseYear(Year.now());

            Set<Category> categories = new HashSet<>();
            categories.add(categoryDAO.getById((byte) 1));
            film.setCategories(categories);
            filmDAO.create(film);

            FilmText filmText = new FilmText();
            filmText.setDescription("one actor");
            filmText.setTitle("one actor");
            filmText.setFilm(film);
            filmText.setId(film.getId());
            filmTextDAO.create(filmText);

            transaction.commit();
        }
    }

    public Customer createCustomer() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);

            City city = cityDAO.getCityByName("Aden");

            Address address = new Address();
            address.setAddress("Khreschatik 1");
            address.setAddress2("Maidan");
            address.setCity(city);
            address.setPhone("911");
            address.setPostalCode("03145");
            address.setDistrict("Pechersk");
            addressDAO.create(address);

            Customer customer = new Customer();
            customer.setAddress(address);
            customer.setStore(store);
            customer.setFirstName("John");
            customer.setLastName("Dou");
            customer.setEmail("aaa@aa.com");
            customer.setActive(true);
            customerDAO.create(customer);

            transaction.commit();
            return customer;
        }
    }

    public void returnRental() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Rental rental = rentalDAO.getSomeRentedItem();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.create(rental);

            transaction.commit();
        }
    }

    public void customerRentInventory(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Film film = filmDAO.getFilmForRent();

            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.create(inventory);

            Staff staff = store.getManagerStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rental.setCustomer(customer);
            rentalDAO.create(rental);

            Payment payment = new Payment();
            payment.setStaff(staff);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setCustomer(customer);
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(32.23));
            paymentDAO.create(payment);

            transaction.commit();
        }
    }

    
}
