package com.tkrs.test.jdk8;


import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
  * @ClassName: Jdk8DateTest  
  * @Description: java8通过发布新的Date-Time API(JSR 310)进一步加强对日期与时间的处理  
  * @author wcg  
  * @date 2018年8月8日  
*/  
    
public class Jdk8DateTest {

	/**
	 * 旧版java日期时间API存在很多问题,java.util.Date非线程安全,所有的日期类都可变
	 * java.util.Date同时包含日期和时间和java.sql.Date只包含日期,名字相同不合理,日期和时间类定义不一致
	 * 时区处理麻烦,日期类不提供国际化,没有时区支持,因此java引入calendar和timezone类,但同样存在上述问题
	 * java8在java.time包下提供了许多新的API,Local(简化日期时间的处理)和Zoned(通过制定的时区处理日期时间)为两个重要的API
	 * 涵盖所有处理日期,时间,日期和时间,时区,时刻,过程(during)与时钟(clock)的操作.
	 */
	
	/**
	 * @Author wcg
	 * @Description 测试获取当前时间LocalDateTime,LocalDate,LocalTime,DateTimeFormatter用法
	 * @Date 9:55 2018/8/10
	 * @Param []
	 * @return void
	 **/
	@Test
	public void testLocalDateTime(){
		//获取当前时间
		LocalDateTime now = LocalDateTime.now();
		System.out.println("当前时间为:"+now);
		LocalDate localDate = LocalDate.now();//获取当日日期
		System.out.println("localDate:"+localDate);
		LocalDate date1 = now.toLocalDate();//LocalDateTime转LocalDate
		System.out.println("date:"+date1);
		//通过now获取年月日时分秒
		Month month = now.getMonth();
		int year = now.getYear();
		int minute = now.getMinute();
		int hour = now.getHour();
		LocalDateTime parseTime2 = LocalDateTime.parse("2018-08-10T10:32:26.125");
		System.out.println("parseTime2:"+parseTime2);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date4 = LocalDateTime.parse("2018-08-12 10:00:00", timeFormatter);
		System.out.println("date4:"+date4);
		System.out.println(timeFormatter.format(now));
	}

	/**
	 * @Author wcg
	 * @Description 使用时区的日期时间API
	 * @Date 9:55 2018/8/10
	 * @Param []
	 * @return void
	 **/
	@Test
	public void testZoned(){
		//获取当前时间日期
		ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
		System.out.println("zonedDateTime:"+zonedDateTime);
		int hour = zonedDateTime.getHour();
		int second = zonedDateTime.getSecond();
		System.out.println("hour:"+hour+",second:"+second);
		ZoneId zoneId = ZoneId.of("Europe/Paris");
		System.out.println("zoneId:"+zoneId);
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("当期时区: " + currentZone);
	}

}
