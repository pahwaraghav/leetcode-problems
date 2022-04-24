class Customer{
    int id;
    String startStation;
    int startTime;
    Customer(){}
    Customer(int id, String startStation,int startTime){
        this.id = id;
        this.startStation = startStation;
        this.startTime = startTime;
    }
}

class Station{
    int totalTime;
    int totalPassengers;
    Station(){
        totalTime = 0;
        totalPassengers = 0;
    }
}
class UndergroundSystem {
    HashMap<Integer,Customer> cus_hmap;
    HashMap<String,Station> sta_hmap;

    public UndergroundSystem() {
        cus_hmap = new HashMap<>();
        sta_hmap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Customer c = new Customer(id,stationName,t);
        cus_hmap.put(id,c);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Customer c = cus_hmap.get(id);
        cus_hmap.remove(id);
        String stationNames = c.startStation + "-" + stationName;
        Station s;
        if(sta_hmap.containsKey(stationNames)){
            s = sta_hmap.get(stationNames);
        }
        else{
            s = new Station();
        }
        s.totalTime += t - c.startTime;
        s.totalPassengers++;
        sta_hmap.put(stationNames,s);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String stationNames = startStation + "-" + endStation;
        Station s = sta_hmap.get(stationNames);
        double avg_time = s.totalTime * 1.0 / s.totalPassengers;
        return avg_time;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */