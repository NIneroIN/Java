1. Создаем класс Country для хранения данных о название страны, региона и показателе щедрости.
    ![image](https://user-images.githubusercontent.com/82171594/147433902-2d01ab0d-9fa1-444d-8430-f322bc79452d.png)

2.Собрал данные о показателе щедрости в странах в 2016 году и с помощью класса ParseCSV, заполнив необходимый набор данных.
      Мы можем заполнить нашу БД:
          С помощью данного кода подключаем SQL к нашей программе и создаем новую таблицу
            ![image](https://user-images.githubusercontent.com/82171594/147434017-fdf27a21-9ab4-46ad-a945-a9cbaf02e5fb.png)
 
 Потом заполняем ее из полученных данных, сохранненых в list
            ![image](https://user-images.githubusercontent.com/82171594/147434110-8ef69ebb-2f54-465f-a4e2-cc6cc0889421.png)

3.Создаем вспомогательный класс LineChart для построения графика
    ![image](https://user-images.githubusercontent.com/82171594/147434300-598a0157-0e3b-4387-9d92-197f7d733254.png)
    
Создаем отдельный метод для построения графика и заполняем dataset'ы из таблицы
    ![image](https://user-images.githubusercontent.com/82171594/147434802-4b02ed40-e529-4db1-bd96-72b45d62b502.png)
        
Получаем график:
    ![image](https://user-images.githubusercontent.com/82171594/147434853-5adfd696-ad6d-4b8f-8ddd-828a8c2d7d79.png)

4.С помощью данного запроса выводим страну с самым низким показателем щедрости среди Middle East and Northern Africa и Central and Eastern Europe
        
![image](https://user-images.githubusercontent.com/82171594/147434508-e33f2818-625c-4c89-9374-2a85ed5c56b1.png)
        ![image](https://user-images.githubusercontent.com/82171594/147434587-905d09a1-7a12-472e-a75a-8786bb2300d8.png)

5.С помощью данного запроса выводим страну с самым средним показателем щедрости среди Southeastern Asia и Sub-Saharan Africa
        
![image](https://user-images.githubusercontent.com/82171594/147434623-e9a14140-553f-4974-b369-6b051dc63bc3.png)
        ![image](https://user-images.githubusercontent.com/82171594/147434628-5283ca0d-806e-4cab-bd02-a8b5082b0218.png)


            
