package config.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import videosystem.DVDPlayer;
import videosystem.DigitalVideoDisc;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스 빈 생성 메소드의 이름으로 Qualifier 하기
	@Autowired
	@Qualifier("avengers")
	private DigitalVideoDisc dvd1;

	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스 빈 생성 메소드의 이름으로 Qualifier 하기
	@Autowired
	@Qualifier("ironMan")
	private DigitalVideoDisc dvd2;

	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스 빈 생성 메소드의 이름으로 Qualifier 하기
	@Autowired
	@Qualifier("dvdPlayer1")
	private DVDPlayer dvdPlayer1;

	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스 빈 생성 메소드의 @Bean의 value(default)속성으로 Qualifier 하기 
	@Autowired
	@Qualifier("dvdPlayer2nd")
	private DVDPlayer dvdPlayer2;

	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스 빈 생성 메소드의 이름으로 Qualifier 하기
	@Autowired
	@Qualifier("dvdPlayer3")
	private DVDPlayer dvdPlayer3;

	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스 빈 생성 메소드의 이름으로 Qualifier 하기
	@Autowired
	@Qualifier("dvdPlayer4")
	private DVDPlayer dvdPlayer4;

	@Test
	public void testDVD1() {
		assertNotNull(dvd1);
	}

	@Test
	public void testDVD2() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDvdPLayer1() {
		assertNotNull(dvdPlayer1);
		assertEquals("Playing Marvel's Avengers", dvdPlayer1.play());
	}

	@Test
	public void testDvdPLayer2() {
		assertNotNull(dvdPlayer2);
		assertEquals("Playing Marvel's Avengers", dvdPlayer2.play());
	}

	@Test
	public void testDvdPLayer3() {
		assertNotNull(dvdPlayer3);
		assertEquals("Playing Marvel's Iron Man", dvdPlayer3.play());
	}

	@Test
	public void testDvdPLayer4() {
		assertNotNull(dvdPlayer4);
		assertEquals("Playing Marvel's Iron Man", dvdPlayer4.play());
	}
	
}