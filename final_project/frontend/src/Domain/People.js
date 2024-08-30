
export class People {
    personId;
    firstname;
    lastname;
    email;
    orders;

    constructor(personId, firstname, lastname, email, orders) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.orders = orders;
    }
}