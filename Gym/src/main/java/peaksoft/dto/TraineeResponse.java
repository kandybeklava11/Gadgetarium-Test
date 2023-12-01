package peaksoft.dto;

public class TraineeResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public TraineeResponse(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public TraineeResponse(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;

    }
}
