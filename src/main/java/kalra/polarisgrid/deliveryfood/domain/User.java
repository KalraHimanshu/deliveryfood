package kalra.polarisgrid.deliveryfood.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User extends BaseJPAEntity{

    private String name;
    private String password;
    private String address;
    private String phone;


}
