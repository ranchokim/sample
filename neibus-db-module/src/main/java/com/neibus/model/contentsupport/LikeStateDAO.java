package com.neibus.model.contentsupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeStateDAO {
  protected Long writeId;
  protected Integer memberIdx;
  protected Boolean isLike;
}
