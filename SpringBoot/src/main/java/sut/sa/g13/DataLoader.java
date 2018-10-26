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
                           QuereRepository quereRepository, TypeWorkRepository typeWorkRepository, StatusRepository statusRepository) {
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
                    customer.setCustomerName("saraban");
                    customer.setTel("0987654321");
                    customer.setEmail("sdf@gmail.com");
                    customerRepository.save(customer);
                }
                if(username == "kankan"){
                    customer.setCustomerName("kantana");
                    customer.setTel("0897687934");
                    customer.setEmail("qweqw@gmail.com");
                    customerRepository.save(customer);
                }

            });

            Stream.of("SUT band", "SweetPop").forEach(artistname -> {
                Artist artist = new Artist();
                artist.setArtistname(artistname);
                if(artistname == "SUT band"){
                    artist.setPrice(100);
                    artist.setTypeMusic("Rock");
                    artistRepository.save(artist);
                }
                if(artistname == "SweetPop"){
                    artist.setPrice(120);
                    artist.setTypeMusic("Pop");
                    artistRepository.save(artist);
                }
            });

            Stream.of("111 มหาวิทยาลัยเทคโนโลยีสุรนารี ถนนมหาวิทยาลัย ตำำบลสุรนารี อำเภอเมือง นครราชสีมา 3000").forEach(place -> {
                Place placeAdd = new Place();
                Quere quere = new Quere();

                String username = "kankan";
                Long artistId = 2L;
                Long typeworkId = 10L;
                Long statusId = 1L;

                String startDate="2018-12-31";
                LocalDate locald = LocalDate.parse(startDate);
                Date date = Date.valueOf(locald);

                String hrs="13";
                String mins="34";
                Time t = new Time(Integer.parseInt(hrs),Integer.parseInt(mins),Integer.parseInt("00"));

                Artist artistquere = artistRepository.findByArtistId(artistId);
                Customer customerquere = customerRepository.findByUsername(username);
                TypeWork choosetypework = typeWorkRepository.findByTypeworkId(typeworkId);
                Status statusquere = statusRepository.findByStatusId(statusId);

                placeAdd.setPlace(place);
                placeAdd.setDate(date);
                placeAdd.setTime(t);
                placeAdd.setHour(3);
                placeRepository.save(placeAdd);

                Place placequere = placeRepository.findByPlaceId(placeAdd.getPlaceId());

                quere.setArtistQuere(artistquere);
                quere.setCustomerQuere(customerquere);
                quere.setPlaceQuere(placequere);
                quere.setTypeworkQuere(choosetypework);
                quere.setStatusQuere(statusquere);
                quereRepository.save(quere);
            });

            customerRepository.findAll().forEach(System.out::println);
            artistRepository.findAll().forEach(System.out::println);
            typeWorkRepository.findAll().forEach(System.out::println);
            statusRepository.findAll().forEach(System.out::println);
            placeRepository.findAll().forEach(System.out::println);
            quereRepository.findAll().forEach(System.out::println);

        };
    }
}

