public enum FeedbackRating {
    AMAZING(1, "Thank you! We are happy with a client like you"),
    GOOD(2, "Thank you for your feedback. We will work on improving our services."),
    BAD(3, "We're sorry to hear that. Please contact customer service.");

    private final int value;
    private final String message;

    FeedbackRating(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
