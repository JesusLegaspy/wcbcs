package com.jlegaspy.wcbcs;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jlegaspy.wcbcs.model.Arc;
import com.jlegaspy.wcbcs.model.Book;
import com.jlegaspy.wcbcs.model.Chapter;
import com.jlegaspy.wcbcs.model.CharacterImportance;
import com.jlegaspy.wcbcs.model.Employee;
import com.jlegaspy.wcbcs.repository.ArcRepository;
import com.jlegaspy.wcbcs.repository.BookRepository;
import com.jlegaspy.wcbcs.repository.ChapterRepository;
import com.jlegaspy.wcbcs.repository.EmployeeRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initEmployeeDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
    };
  }

  @Bean
  CommandLineRunner initBookDatabase(BookRepository repository) {
    return args -> {
      log.info("Preloading " + repository
          .save(new Book("Harry Potter", Long.valueOf(0), 1, "path", new ArrayList<Long>(Arrays.asList(1L, 2L, 3L)))));
    };
  }

  @Bean
  CommandLineRunner initArcDatabase(ArcRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Arc("The Prophesies Begin", 1)));
    };
  }

  @Bean
  CommandLineRunner initChapterDatabase(ChapterRepository repository) {
    ArrayList<CharacterImportance> characterImportance = new ArrayList<CharacterImportance>();
    characterImportance.add(new CharacterImportance(1234L, 8));
    return args -> {
      log.info("Preloading " + repository.save(new Chapter(3, characterImportance)));
    };
  }
}
