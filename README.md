CI/CD for Java Project

## Mô tả dự án

Dự án này triển khai CI/CD tự động cho một ứng dụng Java, với mục tiêu kiểm tra tính hợp lệ của ngày tháng năm. CI/CD pipeline được thiết lập thông qua GitHub Actions để đảm bảo rằng:
- Các bài kiểm tra đơn vị (unit tests) được chạy mỗi khi có thay đổi trong code.
- Nếu tất cả các bài kiểm tra thành công, code sẽ được **deploy** lên **GitHub Pages**.

## Cấu trúc thư mục
CI-CD-SWT/
│
├─ .github/
│ └─ workflows/
│ └─ java-ci-pages.yml (file workflow CI/CD)
│
├─ src/
│ ├─ main/java/date/DateUtils.java
│ └─ test/java/date/DateUtilsTest.java
│
├─ pom.xml
├─ index.html 
└─ README.md

## Cách chạy dự án

### 1. Clone repository

Clone repo này về máy của bạn:

bash:
git clone https://github.com/Ho-VietKhanh/CI-CD-SWT.git
cd CI-CD-SWT


CI/CD với GitHub Actions
Quy trình CI/CD
Khi bạn push code lên GitHub, GitHub Actions sẽ tự động chạy các bước sau:

Build dự án bằng Maven

Chạy unit tests bằng JUnit

Nếu tất cả các tests thành công, GitHub Actions sẽ deploy file index.html lên GitHub Pages.

Các action trong GitHub:

  - mvn clean package: Build ứng dụng.

  - mvn test: Chạy các unit tests.

  - actions/deploy-pages: Deploy lên GitHub Pages.

Cấu hình GitHub Actions

File workflow java-ci-pages.yml nằm trong thư mục .github/workflows/. Để workflow tự động chạy khi có thay đổi, GitHub sẽ theo dõi các sự kiện như push vào nhánh main hoặc pull request từ các nhánh khác.

Cách kiểm tra Test Fail và Success Case
Test Case thành công (Success)

Nếu tất cả các test trong DateUtilsTest đều pass, thì bạn sẽ thấy kết quả trong terminal:

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------


Và trong tab Actions trên GitHub, bạn sẽ thấy trạng thái green (✅) cho job build và job deploy.

Ví dụ test thành công:

Kiểm tra ngày tháng hợp lệ như:

assertTrue(DateUtils.checkDate(2021, 2, 28)); // Ngày hợp lệ: 28 tháng 2

Test Case thất bại (Fail)

Nếu một trong các test fail (ví dụ, assertTrue không đúng), bạn sẽ thấy kết quả như:

------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
[ERROR] Failures:
[ERROR]   DateUtilsTest.testCheckDate_ValidCase:34 
  expected: <true> but was: <false>


Trong trường hợp này, bạn sẽ thấy trạng thái red (❌) trong tab Actions trên GitHub. Job build sẽ fail và job deploy sẽ không chạy.

Ví dụ test thất bại:

Kiểm tra ngày tháng không hợp lệ, ví dụ:

assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 2, 30)); //
