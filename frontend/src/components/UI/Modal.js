//포탈을 사용해서 실제 나타나는 모달 구현.!
import { Fragment,ReactDOM } from "react";
import styled from "./Modal.module.css";
const Backdrop = (props) => {
  return <div className={styled.backdrop} onClose={props.onClose}></div>;
};
const ModalOverlay = (props) => {
  return (
    <div className={styled.modal}>
      <div className={styled.content}>{props.children}</div>
    </div>
  );
};
const portalElement = document.getElementById('overlays');

const Modal = (props) => {
    return <Fragment>
        {ReactDOM.createPortal(<Backdrop onClose={props.onClick}/>,portalElement)}
        {ReactDOM.createPortal(<ModalOverlay>{props.children}</ModalOverlay>,portalElement)}
    </Fragment>
};

export default Modal;
