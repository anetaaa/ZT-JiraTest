package org.jira.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateBody {

  private Fields fields;
}
