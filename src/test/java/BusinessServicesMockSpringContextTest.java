import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import repository.BusinessRepo;
import service.BusinessService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BusinessServicesMockSpringContextTest {

	//@Mock
	@Spy
	BusinessRepo repo;
	
	@InjectMocks
	BusinessService businessImpl;
	
	@Test
	public void testFindTheGreatestFromAllData() {
		when(repo.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(3, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(repo.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(repo.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}
