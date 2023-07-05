## 本次專案主要是要 demo 使用 secret manager 存取 cloud SQL 的密碼後，連線到 cloud SQL 的 demo side project
### 準備步驟:
創建 cloud SQL 並依循 https://cloud.google.com/sql/docs/postgres/connect-instance-cloud-shell 透過 cloud shell 連線到 cloud SQL 建立相關資料，
或者由下方 DB GUI 連線方式，建立相關資料。
於 secret manager 中創建儲存 cloud SQL 密碼的 secret 值，如果資料庫密碼是postgres，就儲存 postgres 的字眼於 secret 值中。

### 透過本機 DB GUI 連線到 cloud SQL:
如果想要透過 DBeaver 或者 Intellij 等本機 DB GUI 連線到 cloud SQL，需要先於 cloud SQL 的連線設定中加入自己的 IP 到已授權網路，
自己電腦的 IP 位置可 google "What is my IP" 進行查看。
連線成功後，如果發現之後又連不上了，可能是因為自己 IP 位址有變，必須要再重新加入新的 IP 到授權網路，並修改 GUI 連線資訊，再次連線。

### 專案設定檔修正:
本專案設定檔皆已拔除私密資訊，需要依照自己 cloud SQL 和 secret 的資訊修正設定檔

### 服務帳戶、使用者帳戶授權:
程式端要串接各項GCP 服務，需要Credential 有對應的 Permission，
現行 Credential 有兩種類型，使用者帳號或是服務帳號。
根據現行GCP IAM 官方推行的設計模式，希望使用者是透過服務帳戶去存取
Permission而不是直接綁在使用者身上。

#### 服務帳戶授權:
使用者需要帶有 `Service Account Token Creator` 的IAM 角色，
服務帳戶需帶有GCP 服務對應的存取角色。(例如本專案就需要 secret manager 和 cloud SQL 權限)

再透過以下Command 存取服務帳號類型的 Credential
`gcloud auth application-default login --impersonate-service-account SERVICE_ACCT_EMAIL`
SERVICE_ACCT_EMAIL 需帶入自己的服務帳戶信箱

### 參考資料:
[从 Cloud Shell 连接到 Cloud SQL for PostgreSQL](https://cloud.google.com/sql/docs/postgres/connect-instance-cloud-shell?hl=zh-cn)

[使用 Secret Manager 处理 Cloud SQL 中的 Secret](https://cloud.google.com/sql/docs/postgres/use-secret-manager?hl=zh-cn)

[创建 Secret](https://cloud.google.com/secret-manager/docs/creating-and-accessing-secrets?hl=zh-cn)