package com.neibus.model.contentsupport;

import java.time.LocalDateTime;

import com.neibus.model.common.SuperImageDAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class S3ImageDAO extends SuperImageDAO {

	protected Long id;
	protected Long imageId;
	protected String type;
	protected String path;
	protected String name;
	protected Long size;
	protected Integer groupNo;
	protected Integer groupOrder;
	protected LocalDateTime modDt;
	protected LocalDateTime regDt;

}
