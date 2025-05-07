# Orange HRM Automation Test (Selenium POM)- PIM And Performance Modules 

### Website : [https://www.opensource-demo.orangehrmlive.com/]

 ## :wrench: Tools:
+ IntelliJ IDEA
+ Maven
+ Selenium WebDriver
+ Page Object Model(POM), 
+ TestNG
+ Allure Report

## :100: The project includes all available test cases:

### :white_check_mark: Test Case 1: Add Employee with correct parameters
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Açılan PIM sayfadaki Add Employee butonuna tıklanır ve Add Employee sayfası açılır
6. Gerekli bilgiler eksiksiz ve doğru bir şekilde doldurularak kaydet butonu tıklanır ve Çalışan Detay sayfasına yönlendirildiği doğrulanır
7. PIM sayfasına gelinir
8. Tüm Employee listesinde yeni eklenen Employee'nin da listede yer aldığı doğrulanır

### :white_check_mark: Test Case 2: Search Employee with correct EmployeeName
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Açılan PIM sayfadaki Add Employee butonuna tıklanır ve Add Employee sayfası açılır
6. Gerekli bilgiler eksiksiz ve doğru bir şekilde doldurularak kaydet butonu tıklanır ve Çalışan Detay sayfasına yönlendirildiği doğrulanır
7. PIM sayfasına gelinir
8. Employee Information'da bulunan formdaki kullanıcının girmiş oldu Employee Name'e uygun doğru filtrelenmiş Employee listesinin getirildiği doğrulanır

### :white_check_mark:Test Case 3: Delete Employee
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Listedeki ilk employee silme işlemi yapılır
6. Listeden silme işlemnin gerçekleştiği doğrulanır


### :white_check_mark: Test Case 4: Verify the count of employees
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Tüm employee sayısının doğruluğu test edilir


### :white_check_mark: Test Case 5: Cancel Delete Employee
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Listedeki ilk employee'nın delete butonuna tıklanır ve çıkan Toast Popup'taki No cancel butona tıklanır ve çalışanın silmediği doğrulanır


### :white_check_mark: Test Case 6: Cancel Delete Report
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Listedeki ilk raporun silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki No cancel butona tıklanır ve raporun silmediği doğrulanır


### :white_check_mark: Test Case 7: Delete Report
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Listedeki ilk raporun silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve raporun silidndiği doğrulanır


### :white_check_mark: Test Case 8: Edit Report
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Listedeki ilk raporun güncellenmesi için edit icon button tıklanır ve Edit Report sayfasına yönledirildiği doğrulanır
7. Edit Report sayfasındaki rapor adı güncellenerek Save butonuna tıkanır
8. Report sayfasında güncellenen raporun adı doğrulanır


### :white_check_mark: Test Case 9: Add Report with Multiple Display Field
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur
7. Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
8. Report sayfasında eklenen raporun adı doğrulanır


### :white_check_mark: Test Case 10: Search Report with correct Report Name
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur
7. Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
8. Employee Reports'da bulunan formdaki kullanıcının girmiş oldu Report Name'e uygun doğru filtrelenmiş Report listesinin getirildiği doğrulanır


### :white_check_mark: Test Case 11: Verify redirection to the report detail page
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Raporlar listesindeki ilk raporun detay icon buttonuna tıklanır
7. Açılan sayfann ilk raporun detay sayfası olduğu doğrulanır


### :white_check_mark: Test Case 12: Add Employee with empty FirstName
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Açılan PIM sayfadaki Add Employee butonuna tıklanır ve Add Employee sayfası açılır
6. Add Employee sayfasındaki Firstname alanı boş bırakılırak Save butonuna tıklanır
7. Ekranda Required uyarısının yer aldığı doğrulanarak kayıt işleminin gerçekleşmediği doğrulanır


### :white_check_mark: Test Case 13: Add Employee with empty Last Name
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Açılan PIM sayfadaki Add Employee butonuna tıklanır ve Add Employee sayfası açılır
6. Add Employee sayfasındaki Last name alanı boş bırakılırak Save butonuna tıklanır
7. Ekranda Required uyarısının yer aldığı doğrulanarak kayıt işleminin gerçekleşmediği doğrulanır


### :white_check_mark: Test Case 14: Add Employee with numeric FirstName
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Açılan PIM sayfadaki Add Employee butonuna tıklanır ve Add Employee sayfası açılır
6. Add Employee sayfasındaki Firstname alanı sayısal değer verilerek Save butonuna tıklanır
7. Employee kayıt edilmemeli


### :white_check_mark: Test Case 15: Add Employee with numeric LastName
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. Açılan PIM sayfadaki Add Employee butonuna tıklanır ve Add Employee sayfası açılır
6. Add Employee sayfasındaki Lastname alanı sayısal değer verilerek Save butonuna tıklanır
7. Employee kayıt edilmemeli


### :white_check_mark: Test Case 16: Add Report with single Display Field
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'PIM' tıklanır
5. PIM sayfasındaki Reports butonuna tıklanarak Raporların olduğu sayfaya yönlendirildiği doğrulanır
6. Raporlar sayfasındaki Add butonu tklanarak Rapor Ekleme sayfasına yönlendirildiği doğrulanur
7. Rapor ekleme sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur(single display field) ve Save butonuna tıklanır
8. Report sayfasında eklenen raporun adı doğrulanır


### :white_check_mark: Test Case 17: Add Key Performance Indicator with correct parameters
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den KPIs tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır
6. Key Performance Indicators for Job Title sayfasındaki Add butonuna tıklanarak Add Key Performance Indicator sayfasına yönlendirildiği doğrulanır
7. Add Key Performance Indicator sayfasındaki alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
8. Key Performance Indicators for Job Title sayfasındaki kayıtlardan yeni eklenen kayıt aranarak listede var olduğu kanıtlanır


### :white_check_mark: Test Case 18: Delete Key Performance Indicator
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den KPIs tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır
6. Listedeki ilk KPI'nin silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve KPI'nin silindiği doğrulanır


### :white_check_mark: Test Case 19: Cancel Delete Key Performance Indicator
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den KPIs tıklanır ve Key Performance Indicators for Job Title sayfasına yönlendirildiği doğrulanır
6. Listedeki ilk KPI'nin silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki No cancel butona tıklanır ve KPI'nin silmediği doğrulanır


### :white_check_mark: Test Case 20: Add Peroformance Tracker with Reviewer on Admin and Add Log inTrackers
1. Tarayıcıyı başlat 2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den Trackers tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
6. Performance Trackers sayfasındaki Add butonuna tıklanr ve Add Performance Tracker sayfasına yönlendirildiği doğrulanır
7. Add Performance Tracker sayfasındaki ilgili alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
8. Performance Trackers sayfasında eklenen raporun adı doğrulanır
9. Employee Trackers tıklanr ve Employee Performance Trackers sayfasına yönlendirildiği doğrulanır
10.Employee Performance Tracker sayfasındaki ilk kayıtın View butonuna tıklanır ve Tracker detay sayfasına yönlendirildiği doğrulanır
11.Tracker detay sayfasındaki Add Log butonu tıklanır
12.Add Tracker Log Dialog penceresindeki gerekli alanlar eksiksiz ve doğru bir şekilde doldurulur ve Save butonuna tıklanır
13.Yeni eklenen Log'un Tracker detay sayfasında göründüğü doğrulanır

   
### :white_check_mark: Test Case 21:  Delete Peroformance Tracker
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den Trackers tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
6. Listedeki ilk Tracker'ın silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki Yes delete butona tıklanır ve Tracker'ın silindiği doğrulanır



### :white_check_mark: Test Case 22: Cancel Delete Perofrmance Tracker
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den Trackers tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
6. Listedeki ilk Tracker'ın silinmesi için delete icon button tıklanır. Ekrandaki Toast Popup'taki No cancel butona tıklanır ve Tracker'ın silmediği doğrulanır


### :white_check_mark: Test Case 23: Edit Peroformance Tracker
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır
4. Sidebar menüsünden 'Performance' tıklanır ve Performance sayfasına yönlendirildiği doğrulanır
5. Configure'den Trackers tıklanır ve Performance Trackers sayfasına yönlendirildiği doğrulanır
6. Listedeki ilk Tracker'ın güncellenmesi için edit icon button tıklanır ve Edit Performance Tracker sayfasına yönlendirildiği doğrulanır
7. Edit Performance Tracker sayfasındaki Tracker adı güncellenerek Save butonuna tıkanır
8. Performance Trackers sayfasında güncellenen trackerın adı doğrulanır



### :white_check_mark: Test Case 24: Login User with correct username and password
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına doğru datalar girilir ve Login butonuna tıklandıktan sonra başarılı bir şekilde Dashboard sayfasına yönlendirildiği doğrulanır


### :white_check_mark: Test Case 25: Login User with incorrect email and password
1. Tarayıcıyı başlat
2. 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login' git
3. Username ve Pasword alanlarına yanlış datalar girilir
4. Login butonuna tıklanır
5. 'Invalid credentials' uyarısının göründüğü doğrulanır
