package pe.com.bootcamp.microservice.account.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection = "tb_perfilcuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PerfilCuentasDTO {
	@Id
	private String id;
	private String description;
	private String status;
	private String classAccount;
	private String CreditCardsAllowed;
	private Double minAmountAverageAllowed;
	private double commissionPerMaintenance;
	private String holder; //titular
	private String legalPerson;
	private String authorizedSigners;
	private String nameTypeAccount;
	private int countMaxAccontsAllowed;
}
