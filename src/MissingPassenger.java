
    public class MissingPassenger extends RuntimeException {
        private Vehicle vehicle;

        public MissingPassenger(Vehicle vehicle) {
            super("Missing passenger at pickup.");
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

