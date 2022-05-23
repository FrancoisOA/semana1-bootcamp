package pe.com.bootcamp.microservice.account.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection = "tb_tipocuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TipoCuentasDTO {
	@Id
	private String id;
	private String description;
	private double commissionPerMaintenance;
	private int numTransactionPerMonth;
	private double openingAmount;
}
