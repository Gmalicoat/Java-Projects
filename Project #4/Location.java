    public class Location {
        private int x;
        private int y;
        private int elevation;

        public Location(int x, int y, int elevation) {
            this.x = x;
            this.y = y;
            this.elevation = elevation;
        }

        public Location() {

        }

        public Location peak() {
            int max = Integer.MIN_VALUE;
            int maxX = 0; int maxY = 0;
            for (int i = 1; i < MountainPass.mountainData.length; i++) {
                for (int j = 0; j < MountainPass.mountainData[i].length; j++) {
                    if (MountainPass.mountainData[i][j] > max) {
                        max = MountainPass.mountainData[i][j];
                        maxX = j;
                        maxY = i;
                    }
                }
            }
            System.out.println("Mountain Peak: (" + maxX + ", " + maxY + ")");  
            return new Location(maxX, maxY, max);
        }

        public Location valley() {
            int min = Integer.MAX_VALUE;
            int minX = 0; int minY = 0;
            for (int i = 1; i < MountainPass.mountainData.length; i++) {
                for (int j = 0; j < MountainPass.mountainData[i].length; j++) {
                    if (MountainPass.mountainData[i][j] < min) {
                        min = MountainPass.mountainData[i][j];
                        minX = j;
                        minY = i;
                    }
                }
            }
            System.out.println("Lowest Point: (" + minX + ", " + minY + ")");
            return new Location(minX, minY, min);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getElevation() {
            return elevation;
        }
    }
