class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i=0; i<position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (a,b) -> b.position - a.position);
        int ans = 1;
        double prev = (target - cars[0].position) * 1.0 / cars[0].speed;
        for(int i=0; i<cars.length; i++) {
            Car c = cars[i];
            double curr = (target - c.position) * 1.0 / c.speed;
            if(curr > prev) {
                ans++;
                prev = curr;
            }
        }
        return ans;
    }
}

class Car {
    int position;
    int speed;
    Car() {}
    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}