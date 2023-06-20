<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Transfer Money</h1>
    <form action="TransferController" method="post">
        <label for="source_account_number">Sender's Account Number:</label>
        <input type="text" name="source_account_number" id="source_account_number" required><br>

        <label for="target_account_number">Recipient's Account Number:</label>
        <input type="text" name="target_account_number" id="target_account_number" required><br>

        <label for="transfer_amount">Transfer Amount:</label>
        <input type="text" name="transfer_amount" id="transfer_amount" required><br>

        <label for="transaction_detail_name">Transaction Detail Name (optional):</label>
        <input type="text" name="transaction_detail_name" id="transaction_detail_name"><br>

        <input type="submit" value="Transfer">
    </form>
</body>
</html>