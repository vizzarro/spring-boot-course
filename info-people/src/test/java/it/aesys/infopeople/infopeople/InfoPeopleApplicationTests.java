package it.aesys.infopeople.infopeople;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.model.Persons;
import it.aesys.infopeople.infopeople.repository.exceptions.EmptyFileSystemRepositoryExcepton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class InfoPeopleApplicationTests {

	@Test
	void testSerializeRepository() {

		PersonFileSystemRepository pr = new PersonFileSystemRepository();

		List<Person> collection = new ArrayList<>();
		Person p = new Person();
		p.setTaxCode("vvvvxs");
		collection.add(p);
		Person p2 = new Person();
		p.setName("Caio");
		p.setTaxCode("dfhsdfhs");
		collection.add(p2);
		Persons persons = new Persons();
		persons.setCollection(collection);

		pr.serializeCollection(persons,"persons.json");
	}

	@Test
	void testUnserializeRepository() {

		PersonFileSystemRepository pr = new PersonFileSystemRepository();

		Persons perWrapper = null;
		try {
			perWrapper = pr.unserialize("persons.json", Persons.class);
		} catch (EmptyFileSystemRepositoryExcepton emptyFileSystemRepositoryExcepton) {
			emptyFileSystemRepositoryExcepton.printStackTrace();
		}

		perWrapper.getCollection().forEach(p -> System.out.println(p));
	}

}
