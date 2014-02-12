package com.unique.overhust.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by shenvsv on 13-12-21.
 */
public class NavigationTools {
    private double[] dis = new double[500];  //
    private int[] pre = new int[500];
    private double[][] w = new double[300][300];
    private int[] edgenum = new int[300];
    private int[][] edge = new int[300][300];
    private boolean[] vis = new boolean[300];
    private int[] path = new int[500];
    //static double[] x = new double[200];
    private double[] x = {0, 30.506333, 30.506397, 30.506277, 30.507100, 30.507100, 30.507137, 30.507941, 30.508450, 30.507960, 30.507756, 30.507710, 30.508052, 30.505937, 30.508673, 30.509219, 30.509367, 30.509727, 30.509773, 30.509847, 30.510115, 30.510125, 30.510531, 30.510273, 30.510069, 30.510069, 30.510781, 30.511021, 30.511086, 30.511160, 30.511243, 30.512149, 30.511955, 30.511835, 30.512251, 30.512288, 30.512463, 30.512075, 30.512214, 30.512075, 30.513594, 30.512186, 30.513733, 30.513779, 30.513843, 30.513973, 30.513270, 30.512817, 30.512808, 30.512817, 30.513307, 30.513344, 30.514028, 30.514028, 30.515720, 30.515757, 30.516163, 30.516228, 30.516484, 30.516481, 30.516361, 30.515520, 30.514919, 30.515012, 30.514494, 30.514124, 30.514438, 30.514115, 30.514060, 30.514291, 30.513535, 30.514200, 30.514311, 30.513988, 30.513900, 30.513401, 30.512421, 30.512685, 30.509935, 30.510882, 30.509773, 30.509625, 30.514584, 30.514843, 30.515092, 30.515323, 30.514039, 30.512477, 30.512393, 30.510425, 30.510508, 30.508705, 30.510665, 30.510841, 30.511876, 30.511709, 30.512209, 30.512061, 30.512421, 30.512625, 30.512791, 30.513530, 30.513715, 30.514455, 30.514640, 30.515527, 30.515619, 30.515684, 30.509202, 30.507742, 30.507271, 30.509323, 30.508186, 30.510974, 30.511981, 30.512102, 30.511076, 30.513044, 30.513950, 30.514172, 30.513229, 30.512296, 30.511251, 30.510345, 30.510068, 30.509097, 30.509168, 30.509223, 30.508040, 30.508031, 30.507587, 30.509307, 30.509852, 30.509473, 30.509926, 30.510305, 30.507791, 30.510480, 30.511442, 30.513457, 30.514326, 30.514492, 30.513605, 30.514649, 30.514326, 30.513725, 30.513467, 30.513374, 30.511733, 30.512602, 30.510772, 30.511086, 30.509635, 30.509986, 30.508637, 30.508304, 30.507546, 30.513998, 30.514913, 30.514885, 30.515070, 30.515236, 30.516272, 30.516124, 30.515939, 30.515874, 30.516817, 30.516623, 30.516512, 30.517066, 30.517159, 30.518222, 30.518000, 30.517806, 30.517510, 30.517334, 30.516447, 30.516364, 30.517177, 30.515551, 30.515449, 30.515338, 30.516429, 30.516392, 30.516521, 30.518259, 30.518323, 30.515246, 30.514857, 30.514848, 0};
    //static double[] y = new double[200];
    private double[] y = {0, 114.431486, 114.430735, 114.432548, 114.432688, 114.432237, 114.431615, 114.430928, 114.430960, 114.430167, 114.431690, 114.432291, 114.433235, 114.432967, 114.433203, 114.431872, 114.430564, 114.433149, 114.431969, 114.433621, 114.434372, 114.433610, 114.433610, 114.432023, 114.434876, 114.434876, 114.434480, 114.434469, 114.433836, 114.433117, 114.432141, 114.432216, 114.433214, 114.433965, 114.434651, 114.434222, 114.432280, 114.431325, 114.431808, 114.431325, 114.436790, 114.435438, 114.435599, 114.435363, 114.434354, 114.432756, 114.432680, 114.432584, 114.432884, 114.432305, 114.432348, 114.431972, 114.432037, 114.432348, 114.432562, 114.432841, 114.432874, 114.432348, 114.432459, 114.432931, 114.433768, 114.433907, 114.434454, 114.433746, 114.435463, 114.435420, 114.435860, 114.435849, 114.436707, 114.437231, 114.437113, 114.430483, 114.429678, 114.429544, 114.428267, 114.427495, 114.427243, 114.425596, 114.424432, 114.424679, 114.426379, 114.428289, 114.428144, 114.426309, 114.423756, 114.421267, 114.421159, 114.421020, 114.422211, 114.422039, 114.420816, 114.421814, 114.418864, 114.417029, 114.417115, 114.419024, 114.419102, 114.420604, 114.417235, 114.419144, 114.417256, 114.419252, 114.417374, 114.419370, 114.417471, 114.419520, 114.418597, 114.417578, 114.416827, 114.416977, 114.416934, 114.415282, 114.415228, 114.415475, 114.415593, 114.414681, 114.414542, 114.414778, 114.414864, 114.412804, 114.412718, 114.412600, 114.412450, 114.412342, 114.414992, 114.414853, 114.413714, 114.413350, 114.413564, 114.413274, 114.413435, 114.412159, 114.412234, 114.410356, 114.411461, 114.410463, 114.410174, 114.410496, 114.410592, 114.410839, 114.410914, 114.409101, 114.408961, 114.407459, 114.405475, 114.407599, 114.405678, 114.405271, 114.405528, 114.407835, 114.405721, 114.408103, 114.405936, 114.408318, 114.408564, 114.406236, 114.408747, 114.414444, 114.414573, 114.414980, 114.412910, 114.411021, 114.411139, 114.413049, 114.415066, 114.415667, 114.415774, 114.417663, 114.418692, 114.413124, 114.411257, 114.411386, 114.413232, 114.415334, 114.417748, 114.419701, 114.419583, 114.421139, 114.421267, 114.407277, 114.408382, 114.409176, 114.409315, 114.410485, 114.408436, 114.409530, 114.408650, 114.405067, 114.405142, 114.405357, 0};

    private int[] linka = {1, 1, 2, 3, 4, 5, 5, 6, 7, 7, 10, 10, 11, 12, 12, 14, 14, 15, 15, 16, 17, 17, 18, 19, 19, 20, 20, 21, 21, 23, 24, 25, 26, 27, 27, 28, 28, 29, 29, 30, 31, 31, 32, 34, 34, 35, 35, 36, 37, 38, 39, 39, 40, 41, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 49, 50, 51, 52, 52, 53, 54, 55, 56, 56, 57, 58, 59, 60, 61, 62, 62, 63, 64, 64, 66, 66, 67, 69, 71, 72, 72, 73, 74, 75, 76, 77, 78, 78, 80, 82, 83, 84, 85, 85, 86, 87, 87, 87, 88, 89, 89, 90, 92, 92, 93, 93, 93, 94, 94, 94, 95, 96, 96, 96, 99, 99, 100, 100, 101, 101, 102, 102, 103, 103, 104, 104, 105, 106, 106, 107, 107, 108, 108, 109, 111, 111, 113, 113, 114, 115, 115, 115, 116, 117, 118, 118, 118, 119, 119, 119, 120, 120, 121, 122, 122, 123, 123, 124, 125, 125, 126, 126, 127, 127, 128, 128, 129, 131, 131, 132, 133, 133, 134, 135, 135, 137, 138, 138, 139, 139, 140, 140, 141, 141, 142, 143, 143, 143, 144, 145, 145, 146, 147, 148, 149, 150, 152, 152, 153, 154, 154, 157, 158, 158, 159, 160, 160, 161, 161, 162, 162, 163, 163, 164, 165, 166, 166, 167, 167, 168, 169, 169, 170, 171, 172, 173, 174, 175, 175, 176, 177, 179, 179, 180, 180, 181, 182, 182, 182, 184, 185, 187, 188};

    private int[] linkb = {2, 3, 7, 4, 5, 11, 6, 10, 8, 9, 11, 15, 12, 13, 14, 17, 24, 16, 18, 81, 18, 19, 23, 21, 20, 26, 24, 22, 23, 30, 25, 26, 27, 28, 34, 29, 33, 32, 30, 31, 36, 38, 33, 35, 39, 36, 44, 49, 38, 51, 41, 40, 42, 42, 43, 44, 65, 45, 63, 46, 53, 47, 50, 48, 49, 50, 51, 52, 53, 71, 54, 55, 56, 57, 59, 58, 59, 60, 61, 62, 63, 64, 65, 65, 66, 67, 69, 68, 70, 72, 73, 83, 74, 75, 76, 77, 79, 79, 80, 81, 83, 84, 85, 86, 105, 87, 88, 99, 90, 89, 90, 91, 92, 93, 95, 108, 94, 103, 95, 104, 98, 96, 98, 97, 99, 100, 101, 102, 117, 102, 103, 104, 118, 104, 105, 107, 159, 106, 168, 107, 162, 165, 109, 111, 110, 112, 113, 114, 116, 115, 116, 117, 121, 122, 120, 119, 157, 159, 120, 140, 160, 121, 139, 122, 138, 123, 124, 137, 125, 126, 128, 127, 128, 131, 129, 130, 129, 131, 132, 133, 134, 135, 136, 135, 137, 153, 138, 151, 139, 142, 140, 141, 161, 142, 143, 145, 179, 144, 145, 189, 146, 149, 147, 148, 150, 151, 151, 153, 155, 154, 155, 156, 158, 159, 160, 164, 161, 163, 162, 181, 183, 163, 169, 164, 165, 166, 167, 169, 168, 174, 176, 170, 172, 171, 172, 173, 174, 175, 178, 176, 177, 178, 180, 181, 181, 184, 182, 184, 185, 183, 186, 186, 188, 189};
    private int[] angle = new int[200];

    private NavigationPoint startPoint;
    private NavigationPoint endPoint;
    private ArrayList<NavigationPoint> points = null;


    public NavigationTools(NavigationPoint startPoint, NavigationPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        points = new ArrayList<NavigationPoint>();
        findPath();
        addPath();
    }

    private void addPath() {
        int i = 0;
        while (path[i] != 0) {
            NavigationPoint point = new NavigationPoint(x[path[i]], y[path[i]]);
            point.setAngle(angle[i + 1]);
            points.add(point);
            point = null;
            i++;
        }
    }

    public ArrayList<NavigationPoint> getPoints() {
        return points;
    }

    private void findPath() {
        // System.out.println("findpath"+startPoint.getiLatitu()+startPoint.getiLongti()+endPoint.getiLatitu()+endPoint.getiLongti());
        fLink();
        Initialization();
        addStartPoint(startPoint.getiLatitu(), startPoint.getiLongti());
        addEndPoint(endPoint.getiLatitu(), endPoint.getiLongti());
        SPFA(0);
        fprint(x.length - 1);
        pathAngle();

    }

    private void fLink() {
        for (int i = 0; i < linka.length; i++) {
            addLink(linka[i], linkb[i]);
        }
    }

    private void addLink(int a, int b) {
        edgenum[a] = edgenum[a] + 1;
        edge[a][edgenum[a]] = b;
        edgenum[b] = edgenum[b] + 1;
        edge[b][edgenum[b]] = a;
        w[a][b] = disAtoB(x[a], y[a], x[b], y[b]) * 10000;
        w[b][a] = w[a][b];
    }

    private double disAtoB(double x1, double y1, double x2, double y2) {
        double len1 = x1 - x2;
        double len2 = y1 - y2;
        return Math.sqrt(len1 * len1 + len2 * len2);
    }

    private void Initialization() {
        for (int i = 0; i < 200; i++) {
            dis[i] = 99999.0;
            pre[i] = i;
            vis[i] = false;

        }
    }

    private void addBusPath() {
        w[83][82] = -1.0;
        w[83][81] = -1.0;
        w[83][80] = -1.0;
        w[83][58] = -1.0;
        w[83][59] = -1.0;
        w[83][60] = -1.0;
        w[83][61] = -1.0;
        w[83][47] = -1.0;
        w[83][46] = -1.0;
        w[83][44] = -1.0;
        w[83][44] = -1.0;

    }

    private void decBusPath() {

    }

    private void addEndPoint(double x1, double y1) {
        x[0] = x1;
        y[0] = y1;
        double minlen = 9999.0;
        for (int i = 1; i < x.length - 1; i++) {
            double temp = disAtoB(x1, y1, x[i], y[i]);
            if (minlen > temp) minlen = temp;
        }

        for (int i = 1; i < x.length - 1; i++) {
            double temp = disAtoB(x1, y1, x[i], y[i]);
            if (1.13 * minlen >= temp) {
                addLink(0, i);
            }
        }


    }

    private void addStartPoint(double x1, double y1) {
        x[x.length - 1] = x1;
        y[x.length - 1] = y1;
        double minlen = 9999.0;
        for (int i = 1; i < x.length - 1; i++) {
            double temp = disAtoB(x1, y1, x[i], y[i]);
            if (minlen > temp) minlen = temp;
        }
        System.out.print(minlen);
        for (int i = 1; i < x.length - 1; i++) {
            double temp = disAtoB(x1, y1, x[i], y[i]);
            if (1.13 * minlen >= temp) {
                addLink(x.length - 1, i);
            }
        }

        //System.out.print(w[x.length-1][1]);
    }

    private boolean Relax(int u, int v, double w) {

        if (dis[u] + w < dis[v]) {
            dis[v] = dis[u] + w;
            pre[v] = u;

            return true;
        }
        return false;

    }

    private void SPFA(int s) {
        dis[s] = 0;

        int now = s;
        int head = 0;
        int tail = 0;
        int[] q = new int[5000];
        int h1 = 0;
        int t1 = 0;
        q[head] = s;
        while (h1 <= t1) {
            now = q[head];
            for (int i = 1; i <= edgenum[now]; i++) {
                if (Relax(now, edge[now][i], w[now][edge[now][i]])) {
                    if (!vis[edge[now][i]]) {
                        tail = tail + 1;
                        t1 = t1 + 1;
                        q[tail] = edge[now][i];
                        vis[edge[now][i]] = true;
                    }
                }

            }
            vis[now] = false;
            head = head + 1;
            h1 = h1 + 1;
        }
    }

    private void fprint(int t) {
        //System.out.println(dis[t]);
        //System.out.print(t);
        int k = 0;
        path[0] = t;

        while (pre[t] != t) {
            //System.out.print("-+>");
            //System.out.print(pre[t]);
            t = pre[t];
            k = k + 1;
            path[k] = t;
        }
        //System.out.println();
        k = 0;
        while (path[k] != 0) {
            System.out.print("-->");
            System.out.print(path[k]);
            k = k + 1;
        }
        System.out.print("-->");
        System.out.print(0);
        System.out.println();

    }

    private void pathAngle() {
        //System.out.println("** ");
        int i = 1;
        while (path[i] != 0) {
            double p1y = x[path[i]] - x[path[i - 1]];
            double p1x = y[path[i]] - y[path[i - 1]];
            /*
			System.out.print(i);
			System.out.print(',');
			System.out.print(p1x);
			System.out.print(',');
			System.out.print(p1y);
			System.out.print(',');
		*/
            angle[i] = 5;
            if ((p1x > 0) && (p1x > p1y) && (p1x > -p1y)) {
                angle[i] = 4;
            }//东
            if ((p1x < 0) && (p1x < p1y) && (p1x < -p1y)) {
                angle[i] = 2;
            } //西
            if ((p1y > 0) && (p1x < p1y) && (p1x > -p1y)) {
                angle[i] = 1;
            } //北
            if ((p1y < 0) && (p1x > p1y) && (p1x < -p1y)) {
                angle[i] = 3;
            } //南
            //System.out.println(angle[i]);
            i = i + 1;

        }
        i = 1;
        int[] tempangle = new int[60];

        while (angle[i] != 0) {
            if ((angle[i - 1] < 5) && (angle[i - 1] > 0) && (angle[i] < 5) && (angle[i] > 0) && (((angle[i - 1] - 1) % 4) == (angle[i] % 4))) {
                tempangle[i] = 1;
            } else {
                if ((angle[i - 1] < 5) && (angle[i - 1] > 0) && (angle[i] < 5) && (angle[i] > 0) && (((angle[i - 1] + 1) % 4) == (angle[i] % 4))) {
                    tempangle[i] = -1;
                } else {
                    tempangle[i] = 2;
                }
            }

            i = i + 1;
        }
        i = 1;
        while (angle[i] != 0) {
            angle[i] = tempangle[i];

            i = i + 1;
        }

        i = 1;
        while (angle[i] != 0) {
            //System.out.print(angle[i]);
            //System.out.print("--->");
            i = i + 1;
        }
        System.out.println("** ");
    }


}