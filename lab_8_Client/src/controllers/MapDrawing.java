package controllers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import  Object.*;
import java.util.*;

class MapDrawing {


    private double plusSize;
    private GraphicsContext gc;
    private TreeSet<StudyGroup> localCollection;
    private Canvas mapCanvas;

    MapDrawing(GraphicsContext gc, TreeSet<StudyGroup> localCollection, Canvas mapCanvas){
        this.gc = gc;
        this.localCollection = localCollection;
        this.mapCanvas = mapCanvas;
    }

    public double getPlusSize() {
        return plusSize;
    }

    void startDrawMap(TreeSet<StudyGroup> newCollection) {
        //Удаление объектов
        Set<Integer> set = new LinkedHashSet<>();
        newCollection.forEach(k -> set.add(k.getId()));
        drawMap(0);
        for (StudyGroup a : localCollection) {
            if (!set.contains(a.getId()))
                removeFlatInMap(a);
        }
        //Добавление новых объектов
        set.clear();
        localCollection.forEach(k -> set.add(k.getId()));
        newCollection.stream()
                .filter(k -> !set.contains(k.getId()))
                .forEach(this::addNewFlatInMap);
        //Изменение координат и размера
        for (StudyGroup newGroup : newCollection) {
            for (StudyGroup localGroup : localCollection) {
                if (newGroup.getId() == localGroup.getId()) {
                    if (newGroup.getStudentsCount() != localGroup.getStudentsCount()
                            || !newGroup.getCoordinates().getX().equals(localGroup.getCoordinates().getX())
                            || !newGroup.getCoordinates().getY().equals(localGroup.getCoordinates().getY())) {
                        changeParametrs(localGroup, newGroup.getCoordinates().getX(),
                                newGroup.getCoordinates().getY(), newGroup.getStudentsCount());
                    }
                }
            }
        }

    }

    private void  changeParametrs(StudyGroup oldGroup, float newX, long newY, int newArea){
        float oldX = oldGroup.getCoordinates().getX();
        long oldY = oldGroup.getCoordinates().getY();
        int oldArea = oldGroup.getStudentsCount();
        for(int i = 1; i <= 80; i++){
            oldGroup.getCoordinates().setX((newX - oldX) * i / 80 + oldX);
            oldGroup.getCoordinates().setY((newY - oldY) * i / 80 + oldY);
            oldGroup.setStudentsCount((newArea - oldArea) * i / 80 + oldArea);
            drawMap(0);
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){}
        }
    }

    // добавление новой группы
    private void addNewFlatInMap(StudyGroup group) {
        localCollection.add(group);
        float xGroup = group.getCoordinates().getX();
        long yGroup = group.getCoordinates().getY();
        double lengthFinal = Math.max(Math.abs(xGroup), Math.abs(yGroup));
        double lengthStart = plusSize;
        if (2 * lengthFinal > plusSize){
            for(int i = 0; i <= 50; i++){
                drawMap((lengthFinal - lengthStart / 2) * i / 50 + lengthStart / 2);
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){}
            }
        }
        double size = setSize(group);
        double x = (group.getCoordinates().getX() + plusSize/2.0) * (mapCanvas.getWidth()/plusSize);//  - size*120/2D;
        double y = (group.getCoordinates().getY() + plusSize/2.0) * (mapCanvas.getWidth()/plusSize);
        animateAdd(group, Color.valueOf(group.getColor()));
        drawMap(0);
    }

    private void removeFlatInMap(StudyGroup group){
        animateRemove(group, Color.valueOf(group.getColor()));
        localCollection.remove(group);
        double pastPlussize = plusSize/2;
        double maxx = localCollection.stream().mapToDouble(flat1 -> flat1.getCoordinates().getX()).max().orElse(10);
        double minx = localCollection.stream().mapToDouble(flat1 -> flat1.getCoordinates().getX()).min().orElse(10);
        double maxy = localCollection.stream().mapToDouble(flat1 -> flat1.getCoordinates().getY()).max().orElse(10);
        double miny = localCollection.stream().mapToDouble(flat1 -> flat1.getCoordinates().getY()).min().orElse(10);
        double localPlusSize = Math.max(Math.max(maxx, Math.max(-Math.min(minx, miny), maxy)), 10);
        if(pastPlussize > localPlusSize){
            for(int i = 50; i >= 0; i--){
                drawMap((pastPlussize - localPlusSize) * i / 50 + localPlusSize);
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){}
            }
        }
        drawMap(0);
    }

    private void animateAdd(StudyGroup group, Color color){
        for(int i = 0; i <= 100; i++) {
            drawMap(0);
            group.setColor(Color.color(color.getRed(), color.getGreen(), color.getBlue(), i* 1.0/100).toString());
            try {
                Thread.sleep(10);
            }catch(InterruptedException e){}
        }
    }

    private void animateRemove(StudyGroup group, Color color){
        for(int i = 100; i >= 0; i--) {
            drawMap(0);
            group.setColor(Color.color(color.getRed(), color.getGreen(), color.getBlue(), i* 1.0/100).toString());
            try {
                Thread.sleep(10);
            }catch(InterruptedException e){}
        }
       // changeParametrs(flat, 0, 0, Integer.MAX_VALUE);
    }

    // отрисовка карты
    private void drawMap(double length){
        gc = mapCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mapCanvas.getWidth(), mapCanvas.getHeight());

        double maxx = localCollection.stream().mapToDouble(group -> group.getCoordinates().getX()+30).max().orElse(10);
        double minx = localCollection.stream().mapToDouble(group -> group.getCoordinates().getX()-30).min().orElse(10);
        double maxy = localCollection.stream().mapToDouble(group -> group.getCoordinates().getY()+30).max().orElse(10);
        double miny = localCollection.stream().mapToDouble(group -> group.getCoordinates().getY()-30).min().orElse(10);
        plusSize = 2 * Math.max(Math.max(Math.max(maxx, Math.max(-Math.min(minx, miny), maxy)), length),10);

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, mapCanvas.getWidth(), mapCanvas.getHeight());

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.strokeLine(0,mapCanvas.getHeight()/2, mapCanvas.getWidth(), mapCanvas.getHeight() / 2);
        gc.strokeLine(mapCanvas.getWidth()/2, 0, mapCanvas.getWidth()/2, mapCanvas.getHeight());
        gc.fillText("0.0", mapCanvas.getWidth()/2, mapCanvas.getHeight()/2 + 20);
        gc.fillText(String.valueOf((int)(-plusSize*2/2.2 / 4)), mapCanvas.getWidth() / 4, mapCanvas.getHeight() / 2 + 20);
        gc.fillText(String.valueOf((int)(plusSize*2/2.2 / 4)), mapCanvas.getWidth() * 3.0 / 4.0, mapCanvas.getHeight() / 2 + 20);

        localCollection.stream().sorted(new Comparator<StudyGroup>() {
            @Override
            public int compare(StudyGroup o1, StudyGroup o2) {
                return (int) (o2.getStudentsCount() - o1.getStudentsCount());
            }
        }).forEach(this::drawGroup);
    }

    // определение параметров группы относительно карты
    private void drawGroup(StudyGroup group)  {
        double size = setSize(group);
        double x = (group.getCoordinates().getX() + plusSize/2.0) * (mapCanvas.getWidth()/plusSize);//  - size*120/2D;
        double y = (group.getCoordinates().getY() + plusSize/2.0) * (mapCanvas.getWidth()/plusSize);// - size*120/2D;
        //TODO: COLOR
        drawElement(x, y,size, 1.0, 1.0, Color.valueOf(group.getColor()));
    }

    // определение размера группы
    private double setSize(StudyGroup group) {
        if (group.getStudentsCount() < 20) return 0.05D*mapCanvas.getWidth()/100;
        if (group.getStudentsCount() > 50) {
            return mapCanvas.getWidth()/800D;
        }
        return group.getStudentsCount()*mapCanvas.getWidth()/40000D;
    }

    //отрисовка человека
    private void drawElement(double x, double y, double size, double opacity, double britness, Color color) {
        x = x - 450 * size / 2;
        y = y - 450 * size / 2;
        gc.setStroke(Color.rgb(0,0,0, color.getOpacity()));

        //голова
        gc.setLineWidth(1);
        gc.beginPath();
        gc.moveTo(x + 173 * size,y + 115 * size);
        gc.quadraticCurveTo(x + 220* size,y + 165* size,x + 290* size,y + 130* size);
        gc.quadraticCurveTo(x + 310* size,y + 120* size,x + 290* size,y + 90* size);
        gc.quadraticCurveTo(x + 300* size,y + 80* size,x + 280* size,y + 50* size);
        gc.lineTo(x + 170* size,y + 50* size);
        gc.lineTo(x + 157* size,y + 85* size);
        gc.quadraticCurveTo(x + 145* size,y + 80* size,x + 143* size,y + 100* size);
        gc.quadraticCurveTo(x + 150* size,y + 125* size,x + 173* size,y + 115* size);
        gc.closePath();
        gc.setFill(Color.rgb(232,171,155, color.getOpacity()));
        gc.fill();
        gc.stroke();

        //нос и рот
        //gc.setLineWidth(1.0);
        gc.moveTo(x + 245* size,y + 92* size);
        gc.quadraticCurveTo(x + 245* size,y + 95* size,x + 255* size,y + 100* size);
        gc.quadraticCurveTo(x + 252* size, y + 104* size,x + 248* size,y + 105* size);
        gc.stroke();
        gc.moveTo(x + 220* size,y + 110* size);
        gc.quadraticCurveTo(x + 235* size,y + 120* size,x + 260* size,y + 115* size);
        gc.stroke();

        gc.setLineWidth(2.5);

        //глаза
        gc.setFill(Color.rgb(255,255,255, color.getOpacity()));
        gc.strokeOval(x + 185* size,y + 71* size,46* size,31* size);
        gc.fillOval(x + 186* size,y + 72* size,44* size,29* size);
        gc.strokeOval(x + 254* size,y + 70* size,40* size,30* size);
        gc.fillOval(x + 255* size,y + 71* size,38* size,28* size);

        gc.setFill(Color.rgb(138,70,52, color.getOpacity()));
        gc.strokeOval(x + 210* size,y + 78* size,22* size,22* size);
        gc.fillOval(x + 211* size,y + 79* size,20* size,20* size);
        gc.strokeOval(x + 275* size,y + 78* size,20* size,20* size);
        gc.fillOval(x + 276* size,y + 79* size,18* size,18* size);

        gc.setFill(Color.rgb(0,0,0,color.getOpacity()));
        gc.fillOval(x + 217* size,y + 83* size,15* size,15* size);
        gc.fillOval(x + 280* size,y + 82* size,15* size,15* size);

        //уши
        gc.moveTo(x + 150* size,y + 95* size);
        gc.quadraticCurveTo(x + 155* size,y + 90* size,x + 165* size,y + 105* size);
        gc.quadraticCurveTo(x + 150* size,y + 105* size,x + 160* size,y + 110* size);
        gc.stroke();

        //волосы
        gc.beginPath();
        gc.moveTo(x + 160* size,y + 45* size);
        gc.quadraticCurveTo(x + 150* size,y + 17* size,x + 220* size,y + 20* size);
        gc.quadraticCurveTo(x + 240* size,y + 20* size,x + 260* size,y + 10* size);
        gc.quadraticCurveTo(x + 260* size,y + 20* size,x + 255* size,y + 20* size);
        gc.quadraticCurveTo(x + 300* size,y + 20* size,x + 315* size,y + 50* size);
        gc.quadraticCurveTo(x + 300* size,y + 40* size,x + 295* size,y + 40* size);
        gc.quadraticCurveTo(x + 315* size,y + 60* size,x + 310* size,y + 75* size);
        gc.quadraticCurveTo(x + 280* size,y + 50* size,x + 240* size,y + 60* size);
        gc.quadraticCurveTo(x + 210* size,y + 70* size,x + 180* size,y + 60* size);
        gc.quadraticCurveTo(x + 182* size,y + 67* size,x + 180* size,y + 80* size);
        gc.quadraticCurveTo(x + 177* size,y + 87* size,x + 180* size,y + 97* size);
        gc.quadraticCurveTo(x + 175* size,y + 97* size,x + 170* size,y + 90* size);
        gc.quadraticCurveTo(x + 170* size,y + 97* size,x + 175* size,y + 105* size);
        gc.quadraticCurveTo(x + 165* size,y + 105* size,x + 155* size,y + 85* size);
        gc.quadraticCurveTo(x + 150* size,y + 83* size,x + 146* size,y + 87* size);
        gc.quadraticCurveTo(x + 120* size,y + 60* size,x + 160* size,y + 45* size);
        gc.closePath();
        gc.setFill(Color.rgb(61,36,35, color.getOpacity()));
        gc.fill();
        gc.stroke();

        //кофта
        gc.beginPath();
        gc.moveTo(x + 190* size,y + 160* size);
        gc.lineTo(x + 155* size,y + 230* size);
        gc.quadraticCurveTo(x + 150* size,y + 260* size,x + 210* size,y + 260* size);
        gc.lineTo(x + 205* size,y + 265* size);
        gc.lineTo(x + 208* size,y + 268* size);
        gc.lineTo(x + 206* size,y + 278* size);
        gc.quadraticCurveTo(x + 235* size,y + 282* size,x + 270* size,y + 278* size);
        gc.lineTo(x + 270* size,y + 270* size);
        gc.lineTo(x + 278* size,y + 260* size);
        gc.quadraticCurveTo(x + 320* size,y + 240* size,x + 300* size,y + 220* size);
        gc.lineTo(x + 260* size,y + 160* size);
        gc.quadraticCurveTo(x + 255* size,y + 145* size,x + 230* size,y + 150* size);
        gc.quadraticCurveTo(x + 195* size,y + 140* size,x + 190* size,y + 160* size);
        gc.closePath();
        gc.setFill(Color.color(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity()));
        gc.fill();

        gc.strokeLine(x + 210* size,y + 180* size,x + 200* size,y + 230* size);
        gc.strokeLine(x + 260* size,y + 180* size,x + 270* size,y + 230* size);
        gc.moveTo(x + 180* size,y + 230* size);
        gc.quadraticCurveTo(x + 190* size,y + 230* size,x + 220* size,y + 240* size);
        gc.moveTo(x + 290* size,y + 225* size);
        gc.quadraticCurveTo(x + 275* size,y + 225* size,x + 265* size,y + 235* size);

        gc.moveTo(x + 210* size,y + 260* size);
        gc.quadraticCurveTo(x + 225* size,y + 250* size,x + 220* size,y + 235* size);
        gc.lineTo(x + 260* size,y + 233* size);
        gc.lineTo(x + 278* size,y + 260* size);
        gc.moveTo(x + 270* size,y + 270* size);
        gc.quadraticCurveTo(x + 238* size,y + 275* size,x + 208* size,y + 268* size);
        gc.moveTo(x + 250* size,y + 273* size);
        gc.quadraticCurveTo(x + 255* size,y + 250* size,x + 245* size,y + 235* size);
        gc.lineTo(x + 240* size,y + 190* size);
        gc.lineTo(x + 260* size,y + 160* size);
        gc.moveTo(x + 240* size,y + 190* size);
        gc.quadraticCurveTo(x + 200* size,y + 150* size,x + 190* size,y + 160* size);
        gc.stroke();

        //футболка
        gc.beginPath();
        gc.moveTo(x + 240* size,y + 180* size);
        gc.lineTo(x + 215* size,y + 155* size);
        gc.quadraticCurveTo(x + 230* size,y + 160* size,x + 248* size,y + 155* size);
        gc.lineTo(x + 240* size,y + 180* size);
        gc.closePath();
        gc.setFill(Color.rgb(199,200,205, color.getOpacity()));
        gc.fill();
        gc.stroke();

        //шея
        gc.beginPath();
        gc.moveTo(x + 215* size,y + 155* size);
        gc.quadraticCurveTo(x + 225* size,y + 145* size,x + 220* size,y + 143* size);
        gc.quadraticCurveTo(x + 230* size,y + 148* size,x + 240* size,y + 145* size);
        gc.quadraticCurveTo(x + 235* size,y + 150* size,x + 245* size,y + 155* size);
        gc.quadraticCurveTo(x + 230* size,y + 160* size,x + 215* size,y + 155* size);
        gc.closePath();
        gc.setFill(Color.rgb(232,171,155, color.getOpacity()));
        gc.fill();
        gc.stroke();

        //кроссы
        //левый
        gc.beginPath();
        gc.moveTo(x + 195* size,y + 415* size);
        gc.lineTo(x + 170* size,y + 426* size);
        gc.quadraticCurveTo(x + 145* size,y + 438* size,x + 175* size,y + 442* size);
        gc.quadraticCurveTo(x + 195* size,y + 440* size,x + 227* size,y + 420* size);
        gc.lineTo(x + 195* size,y + 415* size);
        gc.closePath();
        gc.setFill(Color.rgb(255,255,255,color.getOpacity()));
        gc.fill();
        gc.stroke();

        gc.moveTo(x + 170* size,y + 426* size);
        gc.quadraticCurveTo(x + 155* size,y + 433* size,x + 175* size,y + 435* size);
        gc.lineTo(x + 185* size,y + 433* size);
        gc.stroke();

        gc.beginPath();
        gc.moveTo(x + 195* size,y + 415* size);
        gc.lineTo(x + 170* size,y + 426* size);
        gc.quadraticCurveTo(x + 180* size,y + 425* size,x + 185* size,y + 433* size);
        gc.lineTo(x + 220* size,y + 420* size);
        gc.lineTo(x + 195* size,y + 415* size);
        gc.closePath();
        gc.setFill(Color.rgb(157,125,81,color.getOpacity()));
        gc.fill();
        gc.stroke();

        //правый

        gc.beginPath();
        gc.moveTo(x + 275* size,y + 405* size);
        gc.lineTo(x + 305* size,y + 408* size);
        gc.quadraticCurveTo(x + 335* size,y + 420* size,x + 298* size,y + 428* size);
        gc.lineTo(x + 255* size,y + 418* size);
        gc.lineTo(x + 255* size,y +  410* size);
        gc.lineTo(x + 275* size,y + 405* size);
        gc.closePath();
        gc.setFill(Color.rgb(255,255,255,color.getOpacity()));
        gc.fill();
        gc.stroke();

        gc.beginPath();
        gc.moveTo(x + 275* size,y + 405* size);
        gc.lineTo(x + 305* size,y + 408* size);
        gc.quadraticCurveTo(x + 295* size,y + 417* size,x + 298* size,y + 420* size);
        gc.lineTo(x + 255* size,y + 413* size);
        gc.lineTo(x + 255* size,y + 410* size);
        gc.lineTo(x + 275* size,y + 405* size);
        gc.closePath();
        gc.setFill(Color.rgb(157,125,81, color.getOpacity()));
        gc.fill();
        gc.stroke();

        gc.moveTo(x + 275* size,y + 405* size);
        gc.lineTo(x + 305* size,y + 408* size);
        gc.quadraticCurveTo(x + 327* size,y + 417* size,x + 298* size,y + 420* size);
        gc.stroke();

        //штаны
        gc.beginPath();
        gc.moveTo(x + 208* size,y + 278* size);
        gc.lineTo(x + 200* size,y + 378* size);
        gc.quadraticCurveTo(x + 190* size,y + 400* size,x + 200* size,y + 405* size);
        gc.quadraticCurveTo(x + 180* size,y + 410* size,x + 210* size,y + 420* size);
        gc.quadraticCurveTo(x + 235* size,y + 425* size,x + 235* size,y + 390* size);
        gc.lineTo(x + 235* size,y + 350* size);
        gc.lineTo(x + 245* size,y + 300* size);
        gc.lineTo(x + 240* size,y + 325* size);
        gc.lineTo(x + 245* size,y + 380* size);
        gc.quadraticCurveTo(x + 240* size,y + 415* size,x + 265* size,y + 410* size);
        gc.quadraticCurveTo(x + 295* size,y + 405* size,x + 280* size,y + 395* size);
        gc.quadraticCurveTo(x + 285* size,y + 390* size,x + 275* size,y + 375* size);
        gc.lineTo(x + 263* size,y + 280* size);
        gc.quadraticCurveTo(x + 235* size,y + 282* size,x + 208* size,y + 278* size);
        gc.closePath();
        gc.setFill(Color.rgb(55,48,48, color.getOpacity()));
        gc.fill();
        gc.stroke();
    }
}
