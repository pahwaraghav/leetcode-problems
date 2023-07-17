class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        HashSet<String> hset = new HashSet<>();
        HashMap<String, List<Integer>> ingredientsRecipes = new HashMap<>();
        for(int i=0; i<recipes.length; i++) {
            hmap.put(i, ingredients.get(i).size());
            hset.add(recipes[i]);
            for(int j=0; j<ingredients.get(i).size(); j++) {
                String ingredient = ingredients.get(i).get(j);
                if(!ingredientsRecipes.containsKey(ingredient)) {
                    ingredientsRecipes.put(ingredient, new ArrayList<>());
                }
                ingredientsRecipes.get(ingredient).add(i);
            }
        }
        for(int i=0; i<supplies.length; i++) {
            q.offer(supplies[i]);
        }
        while(!q.isEmpty()) {
            String ingredient = q.poll();
            System.out.println(ingredient);
            if(ingredientsRecipes.containsKey(ingredient)) {
                List<Integer> lis = ingredientsRecipes.get(ingredient);
                for(int val: lis) {
                    if(hmap.containsKey(val)) hmap.put(val, hmap.get(val)-1);
                }
            }
            if(hset.contains(ingredient)) {
                ans.add(ingredient);
            }
            addZeroDegrees(recipes, hmap, q);
        }
        return ans;
    }
    public void addZeroDegrees(String[] recipes, HashMap<Integer,Integer> hmap, Queue<String> q) {
        for(Map.Entry<Integer,Integer> e : hmap.entrySet()) {
            if(e.getValue() == 0) {
                q.offer(recipes[e.getKey()]);
                e.setValue(-1);
            }
        }
    }
}