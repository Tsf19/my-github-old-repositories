package com.tousif.AutowiredWithoutBean5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//	8. creating one more Procecessor
@Component
//@Primary //Refer 10.
public class MediaTek implements MobileProcessor {

	public void process() {
		System.out.println("MediaTek");
	}

}
