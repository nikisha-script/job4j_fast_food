import React, { useState } from 'react';

import '../style/style.css';
import '../style/fonts/font.css';

const doOrder = 'http://localhost:8182/api/v1/orders';

function Order({dishes}) {

    class ApiDtoDish {
      constructor (name, price) {
        this.name = name;
        this.price = price;
      }
    }

    const [fullName, setFullname] = useState('');
    const [address, setAddress] = useState('');
    const [phone, setPhone] = useState('');
    const [deliveryMethodPay, setDeliveryMethodPay] = useState('');
    let sum = 0;
    let apiDishesToOrder = []

    dishes.forEach(e => {
        let dto = new ApiDtoDish(e.name, e.cost);
        apiDishesToOrder.push(dto);
        sum += e.cost;
    });

    return (
          <div className="order">
            <div className="container">
              <div className="wrap">
                <div className="left-wrap">
                  <h2>Оформление заказа</h2>
                  <div className="left-wrap-count">
                    <h3>Вы заказали:</h3>

                    <div className="order-items">
                      {dishes.map(e => {
                          return (
                              <div className="item">
                              <div className="item-photo">
                                  <img src={`data:image/jpg;base64, ${e.img}`} alt=""/>
                              </div>
                              <span>{e.name}</span>
                            
                              <span>{e.cost} ₽</span>
                              </div>
                          )
                      })}
                    </div>


                    <div className="order-footer">
                      <a href="">Доставка</a>
                      <span>Самовывоз (- 20%)</span>
                    </div>
                    <div className="order-total">
                      <div className="order-to-pay">
                        <span>Итого</span>
                        <span>{sum} ₽</span>
                        <span>Итого к оплате</span>
                      </div>
                      <div className="order-to-pay">
                        <span>Доставка</span>
                        <span>0 ₽</span>
                        <span>{sum} ₽</span>
                      </div>

                    </div>
                  </div>
                </div>

                <div className="right-wrap">
                  <div className="input-order">
                    <form action="">
                      <div className="delivery-area">
                        <span>Район доставки</span>
                        <input type="text" id="text" name="text" placeholder="Выбрать" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Выбрать'"  /> 
                      </div>
                      <div className="delivery-area">
                        <span>ФИО</span>
                        <input type="text" id="fullName" name="fullName" value={fullName} placeholder="Введите Ваше полное имя" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Введите Ваше полное имя'" onChange={(event) => setFullname(event.target.value)} /> 
                      </div>
                      <div class="delivery-area">
                        <span>Телефон</span>
                        <input type="text" id="phone" name="phone" value={phone} onChange={(event) => setPhone(event.target.value)} placeholder="+7..." onfocus="this.placeholder = ''" onblur="this.placeholder = '+7...'" /> 
                      </div>
                      <div class="delivery-area">
                        <span>Адрес доставки</span>
                        <input type="text" id="address" name="address" value={address} onChange={(event) => setAddress(event.target.value)} placeholder="Введите адрес доставки" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Введите адрес доставки'" /> 
                      </div>
                      <div className="delivery-area">
                        <span>Способ оплаты</span>
                        <input type="text" id="deliveryMethodPay" name="deliveryMethodPay" value={deliveryMethodPay} onChange={(event) => setDeliveryMethodPay(event.target.value)} placeholder="Наличные" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Наличные'" /> 
                      </div>
                      <button onClick={() => {

                              let order = {
                                price: sum,
                                fullName:fullName,
                                address: address,
                                phone: phone,
                                deliveryMethodPay: deliveryMethodPay,
                                items: apiDishesToOrder
                              }


                              const requestOptions = {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify(order)
                              };

                              fetch(doOrder, requestOptions)
                                  .then(response => response.json()
                                  .catch(function(err) {
                                    console.info(err);
                                  }));
                                
                          
                            }}><span>Оформить заказ</span></button>
                    </form>

                  </div>
                </div>
              </div>
            </div>
        </div>
  
    );
  }

  export default Order;