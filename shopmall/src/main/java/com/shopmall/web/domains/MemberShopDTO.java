package com.shopmall.web.domains;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
@Lazy
public class MemberShopDTO {
	@Getter @Setter private int seq, price;
	@Getter @Setter private String id, date, title, image;
}
