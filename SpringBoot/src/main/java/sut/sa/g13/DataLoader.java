package sut.sa.g13;

import sut.sa.g13.entity.*;
import sut.sa.g13.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.sql.Time;
import java.sql.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DataLoader {
    public static void main(String[] args) {
        SpringApplication.run(DataLoader.class, args);
    }

    @Bean
    ApplicationRunner init(ArtistRepository artistRepository, CustomerRepository customerRepository, PlaceRepository placeRepository,
                           QuereRepository quereRepository, TypeWorkRepository typeWorkRepository, StatusRepository statusRepository,
                           ManagerRepository managerRepository, BandRepository bandRepository) {
        return args -> {
            Stream.of("งานแต่งงาน","งานปาร์ตี้","งานบวช","งานมหาวิทยาลัย","งานเลี้ยง","โรงแรม","ร้านอาหาร","อีเว้นท์ทั่วไป","งาน Event Grand Openning",
                    "งาน Event Pop-up Marget","งาน Event Venue/Mall","อื่นๆ").forEach(type -> {
                TypeWork typeWork = new TypeWork();
                typeWork.setTypeWork(type);
                typeWorkRepository.save(typeWork);
            });

            Stream.of("wait", "success", "cancle").forEach(status -> {
                Status statusquere = new Status();
                statusquere.setStatusQuere(status);
                statusRepository.save(statusquere);
            });

            Stream.of("sawatdee", "kankan").forEach(username -> {
                Customer customer = new Customer();
                customer.setUsername(username);
                if(username == "sawatdee"){
                    customer.setPassword("12345");
                    customer.setCustomerName("saraban");
                    customer.setTel("0987654321");
                    customer.setEmail("sdf@gmail.com");
                    customerRepository.save(customer);
                }
                if(username == "kankan"){
                    customer.setPassword("1");
                    customer.setCustomerName("kantana");
                    customer.setTel("0897687934");
                    customer.setEmail("qweqw@gmail.com");
                    customerRepository.save(customer);
                }

            });

            Stream.of("twit", "monny").forEach(username -> {
                Manager manager = new Manager();
                manager.setUsername(username);
                if(username == "twit"){
                    manager.setPassword("55555");
                    manager.setManagerName("haruhi momo");
                    manager.setTel("0988654321");
                    manager.setEmail("wweqwe@gmail.com");
                    managerRepository.save(manager);
                }
                if(username == "monny"){
                    manager.setPassword("54321");
                    manager.setManagerName("kanika nana");
                    manager.setTel("0897007934");
                    manager.setEmail("qwyyy@hotmail.com");
                    managerRepository.save(manager);
                }

            });

            Stream.of("SUT band", "SweetPop").forEach(bandname -> {
                Band band = new Band();
                band.setBandname(bandname);
                if(bandname == "SUT band"){
                    band.setPrice(100);
                    band.setTypeMusic("Rock");
                    bandRepository.save(band);
                }
                if(bandname == "SweetPop"){
                    band.setPrice(120);
                    band.setTypeMusic("Pop");
                    bandRepository.save(band);
                }
            });

            Stream.of("ttt aaa", "tata tete", "sasa nana", "tyni nani", "tana popo").forEach(artistname -> {
                Long bandId1 = 1L;
                Long bandId2 = 2L;
                Artist artist = new Artist();
                artist.setArtistname(artistname);
                if(artistname == "ttt aaa"){
                    Band band = bandRepository.findByBandId(bandId1);
                    artist.setBand(band);
                    artistRepository.save(artist);
                }
                if(artistname == "tata tete"){
                    Band band = bandRepository.findByBandId(bandId1);
                    artist.setBand(band);
                    artistRepository.save(artist);
                }
                if(artistname == "sasa nana"){
                    Band band = bandRepository.findByBandId(bandId2);
                    artist.setBand(band);
                    artistRepository.save(artist);
                }
                if(artistname == "tyni nani"){
                    Band band = bandRepository.findByBandId(bandId2);
                    artist.setBand(band);
                    artistRepository.save(artist);
                }
                if(artistname == "tana popo"){
                    Band band = bandRepository.findByBandId(bandId2);
                    artist.setBand(band);
                    artistRepository.save(artist);
                }

            });

            Stream.of("111 มหาวิทยาลัยเทคโนโลยีสุรนารี ถนนมหาวิทยาลัย ตำำบลสุรนารี อำเภอเมือง นครราชสีมา 3000").forEach(place -> {
                Place placeAdd = new Place();
                Quere quere = new Quere();

                String username = "kankan";
                Long bandId = 2L;
                Long typeworkId = 10L;
                Long statusId = 1L;

                String startDate="2018-12-31";
                LocalDate locald = LocalDate.parse(startDate);
                Date date = Date.valueOf(locald);

                String hrs="13";
                String mins="34";
                Time t = new Time(Integer.parseInt(hrs),Integer.parseInt(mins),Integer.parseInt("00"));

                Band bandquere = bandRepository.findByBandId(bandId);
                Customer customerquere = customerRepository.findByUsername(username);
                TypeWork choosetypework = typeWorkRepository.findByTypeworkId(typeworkId);
                Status statusquere = statusRepository.findByStatusId(statusId);

                placeAdd.setPlace(place);
                placeAdd.setDate(date);
                placeAdd.setTime(t);
                placeAdd.setHour(3);
                placeRepository.save(placeAdd);

                Place placequere = placeRepository.findByPlaceId(placeAdd.getPlaceId());

                quere.setBandQuere(bandquere);
                quere.setCustomerQuere(customerquere);
                quere.setPlaceQuere(placequere);
                quere.setTypeworkQuere(choosetypework);
                quere.setStatusQuere(statusquere);
                quereRepository.save(quere);
            });

            customerRepository.findAll().forEach(System.out::println);
            managerRepository.findAll().forEach(System.out::println);
            artistRepository.findAll().forEach(System.out::println);
            bandRepository.findAll().forEach(System.out::println);
            typeWorkRepository.findAll().forEach(System.out::println);
            statusRepository.findAll().forEach(System.out::println);
            placeRepository.findAll().forEach(System.out::println);
            quereRepository.findAll().forEach(System.out::println);

        };
    }
}

