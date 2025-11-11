package MVCShapes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private View viewer;
    private Shape[] shapes = new Shape[10]; // масив з 10 фігур
    
    public Controller(Scanner sc){
        this.viewer = new View(sc);
    }
    
    public void processProgram(){
        
        ShapeGenerator shapeGen = new ShapeGenerator(); // генератор фігур
        shapeGen.generateShapes(shapes); // генерація фігур

        int choice;
        
        while(true){
            try{
                choice = viewer.viewMenu();
            } catch(InputMismatchException e){
                choice = 7;
                viewer.sc.nextLine();
            }
            
            switch (choice){
                case 1: 
                    this.processPrintShapes(shapes);
                    break;
                case 2: 
                    this.processPrintShapesInfo(shapes);
                    break;
                case 3: 
                    this.processCalculateShapesArea(shapes);
                    break;
                case 4: 
                    this.processCalculateShapesAreaType(shapes);
                    break;
                case 5: 
                    this.processSortByArea(shapes);
                    break;
                case 6: 
                    this.processSortByColor(shapes);
                    break;
                case 7: 
                    this.processImportShapes();
                    break;
                case 8: 
                    this.processExportShapes(shapes);
                    break;
                case 0: 
                    return;
                default:
                    this.processChoiceError();
                    break;
            }
        }
    }

    public void processPrintShapes(Shape[] shapes){
        
        for (Shape shape : shapes) {
            viewer.printShapes(shape.getName(), shape.draw());
        }
    }

    public void processPrintShapesInfo(Shape[] shapes){
        
        for (Shape shape : shapes) {
            viewer.printShapesInfo(shape.toString());
        }
    }

    public void processCalculateShapesArea(Shape[] shapes){
        float areaSum = AreaCalculator.calculateAllAreas(shapes);
        viewer.printShapesArea(areaSum);
    }

    public void processCalculateShapesAreaType(Shape[] shapes){
        int choice;
        while(true){
            choice = viewer.typeChoice();
            if(choice >= 1 || choice <= 3){
                break;
            }
            viewer.printChoiceTypeError();
        }

        String type;
        if(choice == 1){
            type = "Rectangle";
        }
        else if(choice == 2){
            type = "Triangle";
        }
        else{
            type = "Circle";
        }
        
        float areaSum = AreaCalculator.calculateAreasByType(shapes, type);

        viewer.printShapesAreaType(areaSum, type);
    }

    public void processSortByArea(Shape[] shapes){
        Sorting.sortByArea(shapes);
        viewer.printSortAreaSuccess();
    }

    public void processSortByColor(Shape[] shapes){
        Sorting.sortByColor(shapes);
        viewer.printSortColorSuccess();
    }

    public void processImportShapes(){
        String pathToFile = viewer.printAndReadPathToFile();
        Shape[] importedShapes = IOProcessor.importShapes(pathToFile);
        this.shapes = importedShapes;
        viewer.printSuccessfulImport(pathToFile);
    }

    public void processExportShapes(Shape[] shapes){
        String pathToFile = viewer.printAndReadPathToFile();
        IOProcessor.exportShapes(pathToFile, shapes);
        viewer.printSuccessfulExport(pathToFile);
    }

    public void processChoiceError(){
        viewer.printChoiceError();
    }
}
