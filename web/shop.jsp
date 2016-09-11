
<%@page import="data.DB"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>

<%@page import="java.util.List, entity.Orderline,entity.Cupcake" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Result Page</title>
    </head>
    <body>
        <div class="col-sm-7">
            <h3> Welcome <%out.println(session.getAttribute("username"));%> </h3>

            Your current balance : <%out.println(session.getAttribute("balance"));%>

            <br>
            To buy, please choose desired combination and press button to add to cart.
            <form action="Cart" method="POST">
                <h5>Choose cake bottom:</h5>
                <input type="radio" name="Bottom" value="Chocolate" checked="checked"/>Chocolate<br>
                <input type="radio" name="Bottom" value="Vanilla" />Vanilla<br>
                <input type="radio" name="Bottom" value="Nutmeg" />Nutmeg<br>
                <input type="radio" name="Bottom" value="Pistachio" />Pistachio<br>
                <input type="radio" name="Bottom" value="Almond" />Almond<br>

                <h5>Choose frosting topping:</h5>
                <input type="radio" name="Top" value="Chocolate" checked="checked"/>Chocolate<br>
                <input type="radio" name="Top" value="Blueberry" />Blueberry<br>
                <input type="radio" name="Top" value="Raspberry" />Raspberry<br>
                <input type="radio" name="Top" value="Crispy" />Crispy<br>
                <input type="radio" name="Top" value="Strawberry" />Strawberry<br>
                <input type="radio" name="Top" value="Rum/raisin" />Rum/raisin<br>
                <input type="radio" name="Top" value="Orange" />Orange<br>
                <input type="radio" name="Top" value="Lemon" />Lemon<br>
                <input type="radio" name="Top" value="Blue cheese" />Blue cheese<br>
                <br>
                Amount: <input type="number" name="quantity" min="1" max="99" value="1"><br>
                <br>
                <%
//                    String b = request.getParameter("Bottom");
//                    String t = request.getParameter("Top");
//                    int price = 0;
//                    if (t != null&& b != null &&t.length() != 0 && b.length() != 0) {
//                    
//                        PreparedStatement pstmt = DB.getConnection().prepareStatement("select tPrice,bPrice from tops,bottoms where bFlavour=? and tFlavour=?");
//                        pstmt.setString(1, b);
//                        pstmt.setString(2, t);
//                        ResultSet rs = pstmt.executeQuery();
//                        rs.next();
//
//                        price = (rs.getInt(1) + rs.getInt(2));//*Integer.parseInt(request.getParameter("quantitiy"));
//                    }
//                    out.println(price);
                %>

                <input type="hidden" name="origin" value="add"/>
                <input type="submit" value="Add" />

            </form>
        </div>
        <div class="col-sm-5">
            <h3>Cart</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>Topping</th>
                        <th>Bottom</th>
                        <th>Amount</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>

                    <% List<Orderline> lines = (List<Orderline>) session.getAttribute("lines"); %>

                    <% int total=0;
                    if (lines!=null){
                        for (int i = 0; i < lines.size(); i++) {
                            Orderline line = lines.get(i);
                            Cupcake cake = lines.get(i).getC();
                            out.println("<tr><td>" + cake.getBottom() + "</td><td>" + cake.getTopping() + "</td><td>" + line.getAmount() + "</td><td>" + line.getPrice() + "</td></tr>");
                        total+=line.getPrice();
                        }
}%>


                </tbody>
            </table>
            <h4>Total price: <% out.println(total);%></h4>
            <form action="Cart" method="POST">

                <input type="hidden" name="origin" value="buy"/>                
                <input type="hidden" name="total" value="10" />
                <input type="submit" value="Buy" />
            </form>
        </div>
        <script src="scripts/shopscript.js" type="text/javascript"></script>

    </body>
</html>
