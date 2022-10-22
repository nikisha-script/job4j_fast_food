import React, { useState, useEffect } from 'react';
import './style/style.css';
import './style/fonts/font.css';
import logo from './style/img/header/full_logo.png';
import phone from './style/img/header/phone.png';
import person from './style/img/header/person.png';
import card from './style/img/header/shopping-cart.png';
import Home from './pages/Home';
import Order from './pages/Order';
import {
  Route,
  Routes,
  Link
} from "react-router-dom";

const getAllCategories = 'http://localhost:8183/api/v1/categories';

function App() {

  const [categories, setCategories] = useState([]);
  const [dish, setDish] = useState([]);
  const [count, setCount] = useState(0);

  useEffect(() => {
    fetch(getAllCategories)
      .then(res => res.json())
      .then(
        (result) => {
          setCategories(result);
        }
      )
  }, [])

  return (
    <div className="wrapper">
        <header>
            <nav className="navbar navbar-expand-lg bg-light">
                <div className="container">
                  <Link className="navbar-brand" to="/">
                    <img src={logo} alt="#"/>
                  </Link>
                  <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                  </button>
                  <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2">
                      <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                              Меню
                            </a>
                            <div className="dropdown-menu">
                              {categories.map(e => {
                                return(
                                  <a className="dropdown-item" href="#">
                                    <span><img src={`data:image/jpg;base64, ${e.img}`}/></span> 
                                      {e.name}
                                  </a>
                                )
                              })};
                         
                            </div>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="page.html">Доставка</a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="#">Оплата</a>
                      </li>
                      <li className="nav-item">
                        <a href="booking.html" className="nav-link">Поддержка</a>
                      </li>
                    </ul>
                    
                    <div className="menu-right d-flex">
                        <div className="menu-contact">
                            <a href="tel: +78312826000">
                                <img src={phone} alt=""/>
                                <span>+7 (831) 282-60-00</span>
                            </a>
                        </div>
                        <div className="menu-user">
                            <button className="profile" data-bs-toggle="modal" data-bs-target="#login">
                                <img src={person} alt="#"/>
                            </button>
                            <Link className="cart" to="/order">
                                <img src={card} alt=""/>
                                  {count !== 0 && (
                                    <span>{count}</span>
                                  )} 
                            </Link>
                        </div>
                    </div>
                  </div>
                </div>
              </nav>
        </header>

        <Routes>
          <Route path='/' element = {<Home dish = {dish} onClickBtnDish = {(e) => {
              setDish(e)
              setCount(count + 1);
            }}/>} />
          <Route path='/order' element = {<Order dishes = {dish}/>} />
        </Routes>

        <footer>
            <div className="container">
                <div className="footer-wrapper">
                    <div className="footer-left">
                        <div className="phones">
                            <div className="phone-item">
                                <span>Бесплатный звонок по РФ</span>
                                <a href="tel:+78312826000">+7 (831) 282-60-00</a>
                            </div>
                            <div className="phone-item">
                                <span>Для приема заказов</span>
                                <a href="tel:+79040664685">+7 (904) 066-46-85</a>
                            </div>
                        </div>
                        <div className="work-time">
                            График работы по будням с 9:00 до 18:00
                        </div>
                        <div className="work-email">
                            <a href="mailto: danya.nikisha@mail.ru">Email: danya.nikisha@mail.ru</a>
                            <a href="" className="site-help">Поддержка</a>
                        </div>
                    </div>
                    <div className="footer-center">
                        <div className="social">
                            <a href="https://vk.com/d.nikishin" target="_blank">Мы в вконтакте</a>
                        </div>
                    </div>
                    <div className="footer-right">
                        <div className="person">
                            <a href="" data-bs-toggle="modal" data-bs-target="#reg"><img src="style/img/prd/person.png" alt=""/><span>Войти / Регистрация</span></a>
                        </div>
                    </div>
                    
                </div>
                <div className="footer_bottom">
                    <span>©2020. Пиросмани</span>
                    <a href="">Условия и соглашения</a>
                    <a href="">Политика конфиденциальности</a>
                </div>
            </div>
        </footer>

    </div>
  );
}
 
export default App;
