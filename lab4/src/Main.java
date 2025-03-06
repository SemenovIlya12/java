import java.util.*;
import java.util.function.*;


public class Main {

    public double GetMaxInBoxes(Collection<box<? extends Number>> boxes) {
        double max = Double.NEGATIVE_INFINITY;
        for (box<? extends Number> box : boxes) {
            Number temp = box.get();
            if (temp.doubleValue() > max) max = temp.doubleValue();
        }

        return max;
    }

    interface Transformer<T, P> {
        P apply(T item);
    }

    public <T, P> List<P> transform(List<T> List, Transformer<T, P> transformer) {
        List<P> result = new ArrayList<P>();

        for (T item : List) {
            result.add(transformer.apply(item));
        }
        return result;
    }

    interface Tester<T> {
        boolean Test(T item);
    }

    public <T> List<T> TestList(List<T> List, Tester ts) {
        List<T> result = new ArrayList<T>();

        for (T item : List) {
            if (ts.Test(item)) result.add(item);
        }

        return result;
    }

    interface ShrinkMethod<T> {
        T Shrink(List<T> item);
    }

    public <T> T ShrinkList(List<T> List, ShrinkMethod<T> method, T defaultVal) {
        //String err = "Error";
        if (List.isEmpty()) return defaultVal;
        return method.Shrink(List);
    }


    public <T,P> List<P> Collecting(List<T> List) {

    }


    //public <T,P>

    public static void main(String[] args) {
        System.out.println("Enter number of a task");
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        try {
            int id = sc.nextInt();

            switch (id) {
                case 1: {
                    box<Integer> box1 = new box<Integer>();
                    System.out.println(box1.isEmpty());
                    box1.SetItem(3);
                    System.out.println(box1);

                    int item = box1.get();
                    System.out.println(item);
                } break;
                case 2 : {
                    AgeCompr age1 = new AgeCompr(22);
                    AgeCompr age2 = new AgeCompr(33);
                    System.out.println(age1.compare(age2));
                } break;
                case 3 : {
                    box<Integer> b1 = new box<Integer>();
                    b1.SetItem(4);
                    box<Double> b2 = new box<Double>();
                    b2.SetItem(52.1234);
                    box<Double> b3 = new box<Double>();
                    b3.SetItem(-67.434);

                    Collection<box<? extends Number>> boxes = new ArrayList<box<? extends Number>>();
                    boxes.add(b1);
                    boxes.add(b2);
                    boxes.add(b3);


                    System.out.println(m.GetMaxInBoxes(boxes));
                } break;
                case 4 : {
                    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                    List<Integer> lengs = m.transform(strings, new Transformer<String, Integer>() {
                        @Override
                        public Integer apply(String item) {
                            return item.length();
                        }
                    });
                    System.out.println(lengs);

                    List<Integer> ints = Arrays.asList(1,-3,-7);
                    List<Integer> abs = m.transform(ints, new Transformer<Integer, Integer>() {
                        @Override
                        public Integer apply(Integer item) {
                            return Math.abs(item);
                        }
                    });

                    System.out.println(abs);

                    List<int[]> arrays = Arrays.asList(
                            new int[]{1, 2, 3},
                            new int[]{-1, -2, -3},
                            new int[]{4, 5, 6}
                    );

                    List<Integer> maxes = m.transform(arrays, new Transformer<int[], Integer>() {
                        @Override
                        public Integer apply(int[] item) {
                            int max = Integer.MIN_VALUE;
                            for (int num : item) {
                                if (num > max) max = num;
                            }
                            return max;
                        }
                    });

                    System.out.println(maxes);

                } break;
                case 5 : {
                    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                    List<String> FilteredStrings = m.TestList(strings, new Tester<String>() {
                        @Override
                        public boolean Test(String item) {
                            return item.length() > 3;
                        }
                    });
                    System.out.println(FilteredStrings);

                    List<Integer> ints = Arrays.asList(1,-3,-7);
                    List<Integer> FilteredNums = m.TestList(ints, new Tester<Integer>() {
                        @Override
                        public boolean Test(Integer item) {
                            return item < 0;
                        }
                    });

                    System.out.println(FilteredNums);

                    List<int[]> arrays = Arrays.asList(
                            new int[]{1, 2, 3},
                            new int[]{-1, -2, -3},
                            new int[]{4, 5, 6},
                            new int[]{1,-2,4}
                    );

                    List<int[]> FilteredArrays = m.TestList(arrays, new Tester<int[]>() {
                        @Override
                        public boolean Test(int[] item) {
                            boolean flag = true;
                            for (int num : item) {
                                if (num < 0) flag = false;
                            }
                            return flag;
                        }
                    });

                    for (int[] arr : FilteredArrays){
                        System.out.println();
                        for (int i : arr) {
                            System.out.print(i+" ");
                        }
                    }

                } break;
                case 6 : {
                    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                    String ofStrings = m.ShrinkList(strings, new ShrinkMethod<String>() {
                        @Override
                        public String Shrink(List<String> item) {
                            StringBuilder sb = new StringBuilder();
                            for (String str : item) {
                                sb.append(str);
                            }
                            return sb.toString();
                        }
                    }, "");

                    System.out.println(ofStrings);


                    List<Integer> ints = Arrays.asList(1,-3,-7);
                    int summ = m.ShrinkList(ints, new ShrinkMethod<Integer>() {
                        @Override
                        public Integer Shrink(List<Integer> item) {
                            int sum = 0;
                            for (int i : item) {
                                sum += i;
                            }
                            return sum;
                        }
                    }, 0);

                    System.out.println(summ);

                    List<List<Integer>> arrays = Arrays.asList(
                            Arrays.asList(1, 2, 3),
                            Arrays.asList(-1, -2, -3),
                            Arrays.asList(4, 5, 6)
                    );



                    List<Integer> count = m.ShrinkList(arrays, new ShrinkMethod<List<Integer>>() {
                        @Override
                        public List<Integer> Shrink(List<List<Integer>> item) {
                            int cnt = 0;
                            for (List<Integer> sub : item) {
                                cnt += sub.size();
                            }
                            return Arrays.asList(cnt);
                        }
                    }, Arrays.asList(0));

                    System.out.println(count.get(0));

                    //Collection b = Arrays.asList(1,2,3,4);

                } break;
                case 7 : {

                } break;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
